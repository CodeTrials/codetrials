package org.codetrials.server.web.controllers;

import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.server.rpc.RPCRequest;
import com.google.gwt.user.server.rpc.RPCServletUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Nikita Zyulyaev
 */
public abstract class AbstractRemoteService {
    @Autowired
    private ServletContext context;

    protected ThreadLocal<HttpSession> session = new ThreadLocal<>();

    @RequestMapping(method = RequestMethod.POST)
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pl = RPCServletUtils.readContentAsGwtRpc(request);
        RPCRequest rpc = RPC.decodeRequest(pl, getClass());
        session.set(request.getSession());
        String rpcResponse = RPC.invokeAndEncodeResponse(
                this,
                rpc.getMethod(),
                rpc.getParameters(),
                rpc.getSerializationPolicy(),
                rpc.getFlags()
        );
        boolean gzipEncode = RPCServletUtils.acceptsGzipEncoding(request)
                && RPCServletUtils.exceedsUncompressedContentLengthLimit(rpcResponse);

        RPCServletUtils.writeResponse(context, response, rpcResponse, gzipEncode);
    }
}
