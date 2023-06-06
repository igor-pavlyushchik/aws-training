package com.epam.aws.training.controller;

import com.epam.aws.training.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

  private final NotificationService notificationService;

  @PostMapping("/subscriptions/{email}")
  public void subscribeEmail(@PathVariable String email) {
    notificationService.subscribeEmail(email);
  }

  @DeleteMapping("/subscriptions/{email}")
  public void unsubscribeEmail(@PathVariable String email) {
    notificationService.unsubscribeEmail(email);
  }
}
