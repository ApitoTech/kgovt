package com.kgovt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgovt.models.WebhookResponse;
import com.kgovt.repositories.WebhookResponseRepository;
import com.kgovt.utils.AppConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WebhookResponseService extends AppConstants{

	@Autowired
	private WebhookResponseRepository webhookResponseRepository;
		
	public WebhookResponse saveWebhookResponse(WebhookResponse webhookResponse)  {
		webhookResponse = webhookResponseRepository.save(webhookResponse);
		return webhookResponse;
	}
	
}
