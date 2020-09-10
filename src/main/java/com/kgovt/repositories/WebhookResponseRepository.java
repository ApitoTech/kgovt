package com.kgovt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kgovt.models.PaymentDetails2;
import com.kgovt.models.WebhookResponse;

public interface WebhookResponseRepository extends JpaRepository<WebhookResponse, Integer> {

	

}
