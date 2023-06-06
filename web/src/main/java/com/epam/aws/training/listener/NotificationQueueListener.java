package com.epam.aws.training.listener;

import com.epam.aws.training.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationQueueListener {

  private final NotificationService notificationService;

  // Comment scheduler to substitute it with lambda function.
  /*@Scheduled(fixedRate = 3000)
  public void readBatchFromQueueAndPushToTopic() {
    var messages = notificationService.readMessages();
    messages.forEach(message -> notificationService.sendMessageToTopic(message.getBody()));
  }*/
}
