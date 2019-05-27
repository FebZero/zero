//package com.sc.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//import com.sc.common.websocket.SpringWebSocketHandler;
//import com.sc.common.websocket.SpringWebSocketHandlerInterceptor;
//
//
//@Configuration
//@EnableWebSocket
//public class WebSocketConfig implements WebSocketConfigurer {
//	/**
//	 * 注册Websocket拦截器
//	 */
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        registry.addHandler(webSocketHandler(),"/websocket/socketServer").addInterceptors(new SpringWebSocketHandlerInterceptor());
//        registry.addHandler(webSocketHandler(), "/sockjs/socketServer").addInterceptors(new SpringWebSocketHandlerInterceptor()).withSockJS();
//    }
//    /**
//     * 注册WebSocket消息处理器
//     * @return
//     */
//    @Bean
//    public SpringWebSocketHandler webSocketHandler(){
//        return new SpringWebSocketHandler();
//    }
//}