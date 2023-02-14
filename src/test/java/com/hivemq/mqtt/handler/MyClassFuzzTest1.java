package com.hivemq.mqtt.handler;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;
import com.hivemq.extension.sdk.api.annotations.NotNull;
import com.hivemq.extensions.handler.*;
import com.hivemq.mqtt.handler.InterceptorHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class MyClassFuzzTest1 {
    @Mock
    private @NotNull ConnectInboundInterceptorHandler connectInboundInterceptorHandler;
    @Mock
    private @NotNull ConnackOutboundInterceptorHandler connackOutboundInterceptorHandler;
    @Mock
    private @NotNull PublishOutboundInterceptorHandler publishOutboundInterceptorHandler;
    @Mock
    private @NotNull PubackInterceptorHandler pubackInterceptorHandler;
    @Mock
    private @NotNull PubrecInterceptorHandler pubrecInterceptorHandler;
    @Mock
    private @NotNull PubrelInterceptorHandler pubrelInterceptorHandler;
    @Mock
    private @NotNull PubcompInterceptorHandler pubcompInterceptorHandler;
    @Mock
    private @NotNull SubackOutboundInterceptorHandler subackOutboundInterceptorHandler;
    @Mock
    private @NotNull UnsubscribeInboundInterceptorHandler unsubscribeInboundInterceptorHandler;
    @Mock
    private @NotNull UnsubackOutboundInterceptorHandler unsubackOutboundInterceptorHandler;
    @Mock
    private @NotNull PingInterceptorHandler pingInterceptorHandler;
    @Mock
    private @NotNull DisconnectInterceptorHandler disconnectInterceptorHandler;
    @Mock
    private @NotNull ChannelHandlerContext channelHandlerContext;
    @Mock
    private @NotNull ChannelPromise channelPromise;

    private @NotNull InterceptorHandler interceptorHandler;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.interceptorHandler = new InterceptorHandler(
                connectInboundInterceptorHandler,
                connackOutboundInterceptorHandler,
                publishOutboundInterceptorHandler,
                pubackInterceptorHandler,
                pubrecInterceptorHandler,
                pubrelInterceptorHandler,
                pubcompInterceptorHandler,
                subackOutboundInterceptorHandler,
                unsubscribeInboundInterceptorHandler,
                unsubackOutboundInterceptorHandler,
                pingInterceptorHandler,
                disconnectInterceptorHandler);
    }
    @FuzzTest
    void myFuzzTest(FuzzedDataProvider data) {
        try {
            setUp();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // Call the functions you want to test with the provided data and optionally
        // assert that the results are as expected.

        // If you want to know more about writing fuzz tests you can checkout the
        // example projects at https://github.com/CodeIntelligenceTesting/cifuzz/tree/main/examples
        // or have a look at our tutorial:
        // https://github.com/CodeIntelligenceTesting/cifuzz/blob/main/docs/How-To-Write-A-Fuzz-Test.md
        final byte[] payload1 = data.consumeBytes(data.remainingBytes());
        // TODO: Verify persistence
        interceptorHandler.channelRead(channelHandlerContext, payload1);
    }
}
