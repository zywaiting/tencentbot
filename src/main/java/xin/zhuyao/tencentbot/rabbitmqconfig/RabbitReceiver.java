package xin.zhuyao.tencentbot.rabbitmqconfig;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import xin.zhuyao.tencentbot.pojo.WechatSubscriptionEntity;

import java.util.Map;

@Component
@Slf4j
public class RabbitReceiver {

	/**
	 * 
	 * 	spring.rabbitmq.listener.order.queue.name=queue-1
		spring.rabbitmq.listener.order.queue.durable=true
		spring.rabbitmq.listener.order.exchange.name=exchange-1
		spring.rabbitmq.listener.order.exchange.durable=true
		spring.rabbitmq.listener.order.exchange.type=topic
		spring.rabbitmq.listener.order.exchange.ignoreDeclarationExceptions=true
		spring.rabbitmq.listener.order.key=springboot.*
	 * @param wechatSubscriptionEntity
	 * @param channel
	 * @param headers
	 * @throws Exception
	 */
	@RabbitListener(bindings = @QueueBinding(
			value = @Queue(value = "${spring.rabbitmq.listener.order.queue.name}", 
			durable="${spring.rabbitmq.listener.order.queue.durable}"),
			exchange = @Exchange(value = "${spring.rabbitmq.listener.order.exchange.name}", 
			durable="${spring.rabbitmq.listener.order.exchange.durable}", 
			type= "${spring.rabbitmq.listener.order.exchange.type}", 
			ignoreDeclarationExceptions = "${spring.rabbitmq.listener.order.exchange.ignoreDeclarationExceptions}"),
			key = "${spring.rabbitmq.listener.order.key}"
			)
	)
	@RabbitHandler
	public void onProjectMessage(@Payload WechatSubscriptionEntity wechatSubscriptionEntity, Channel channel, @Headers Map<String, Object> headers)
			throws Exception {
		if(1==1){

			Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
			//手工ACK
			channel.basicAck(deliveryTag, false);
		}else {
			//TODO 业务逻辑

			Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
			//手工ACK
			channel.basicAck(deliveryTag, false);
		}

	}
	
	
}
