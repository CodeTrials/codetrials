package org.codetrials.client.core.events;

import org.codetrials.client.core.logging.Log;
import org.codetrials.client.core.natives.JsList;
import org.codetrials.client.core.natives.JsMap;
import org.codetrials.client.core.natives.NativeUtils;

/**
 * @author Nikita Zyulyaev
 */
class EventBusImpl implements EventBus {
    private final JsMap<CopyOnWriteJsList<Handler<?>>> handlersMap = NativeUtils.map();

    private static String getKey(EventType<?> type, String classifier) {
        return type.id + "|" + classifier;
    }

    private static String getKey(EventType<?> type) {
        return getKey(type, null);
    }

    private static String getKey(ClassifiedEventType<?> type) {
        return getKey(type.getType(), type.getClassifier());
    }

    private static <T> void fireAll(CopyOnWriteJsList<Handler<?>> handlers, final T value) {
        if (handlers == null) return;
        JsList<Handler<?>> data = handlers.getData();
        for (int i = 0, len = data.length(); i < len; ++i) {
            Handler<T> handler = (Handler<T>) data.get(i);
            try {
                handler.handle(value);
            } catch (RuntimeException e) {
                Log.error(e);
            }
        }
    }

    @Override
    public <T> EventSubscription<T> subscribe(EventType<T> type, Handler<? super T> handler) {
        return new Subscription<>(type, null, handler);
    }

    @Override
    public <T> ClassifiedEventSubscription<T> subscribe(ClassifiedEventType<T> type, Handler<? super T> handler) {
        return new Subscription<>(type.getType(), type.getClassifier(), handler);
    }

    @Override
    public <T> ClassifiedEventSubscription<T> subscribe(EventType<T> type, String classifier, Handler<? super T> handler) {
        return new Subscription<>(type, classifier, handler);
    }

    @Override
    public <T> void fire(EventType<T> type, T value) {
        fireAll(handlersMap.get(getKey(type)), value);
    }

    @Override
    public <T> void fire(ClassifiedEventType<T> type, T value) {
        fireAll(handlersMap.get(getKey(type)), value);
    }

    @Override
    public <T> void fire(EventType<T> type, String classifier, T value) {
        fireAll(handlersMap.get(getKey(type, classifier)), value);
    }

    private class Subscription<T> implements ClassifiedEventSubscription<T> {
        private final EventType<T> type;
        private final String classifier;
        private final Handler<? super T> handler;
        private final String key;

        private Subscription(EventType<T> type, String classifier, Handler<? super T> handler) {
            this.type = type;
            this.classifier = classifier;
            this.handler = handler;
            this.key = getKey(type, classifier);

            if (!handlersMap.containsKey(key)) {
                handlersMap.put(key, new CopyOnWriteJsList<Handler<?>>(handler));
            } else {
                handlersMap.get(key).add(handler);
            }
        }

        @Override
        public String getClassifier() {
            return classifier;
        }

        @Override
        public EventType<T> getEventType() {
            return type;
        }

        @Override
        public Handler<? super T> getHandler() {
            return handler;
        }

        @Override
        public boolean unsubscribe() {
            CopyOnWriteJsList<?> array = handlersMap.get(key);
            if (!array.remove(handler)) {
                return false;
            }
            if (array.isEmpty()) {
                handlersMap.remove(key);
            }
            return true;
        }
    }
}
