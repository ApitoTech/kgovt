package com.kgovt.controllers;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kgovt.datatable.paging.Page;
import com.kgovt.datatable.paging.PagingRequest;
import com.kgovt.models.ApplicationDetailes;
import com.kgovt.models.WebhookResponse;
import com.kgovt.services.ApplicationDetailesService;
import com.kgovt.services.WebhookResponseService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AppListRestController {
	@Autowired
	private ApplicationDetailesService appicationService;
	
	@Autowired
	private WebhookResponseService webhookResponseService;
	
	
	
	@PostMapping("/allApplicationData")
	public Page<ApplicationDetailes> list(@RequestBody PagingRequest pagingRequest,@RequestParam String region, String status) {
		return appicationService.getApplicationDetailess(pagingRequest,region, status);
	}
	
	@PostMapping("/getAllApplicationData")
	public Page<ApplicationDetailes> list(@RequestBody PagingRequest pagingRequest) {
		return appicationService.getApplicationDetailess(pagingRequest);
	}
	
	@PostMapping("/myWebhook")
	  public void getMyJson(@RequestBody Map<String, Object> json) {
	  System.out.println("WebHook collected JSON: " + json);
	  log.info("Web hook verification called5 rest");
		log.info("return data " + json.toString());
		try {
			WebhookResponse web=new WebhookResponse();
//			JSONObject jsonObj = new JSONObject(json.toString());
//			System.out.println(jsonObj);
//			String accountId = jsonObj.getString("account_id");
//			web.setAccountId(accountId);
//			String payLoadObj = jsonObj.getString("payload");
//			JSONObject paymentJsonObj = new JSONObject(payLoadObj);
//			
//			String paymentObj = paymentJsonObj.getString("payment");
//			System.out.println(paymentObj);
//			
//			JSONObject entityJsonObj1 = new JSONObject(paymentObj);
//			String entity = entityJsonObj1.getString("entity");
//			
//			JSONObject entityMetaObj = new JSONObject(entity);
//				
//			String contact = entityMetaObj.getString("contact");
//			web.setContact(contact);
//			String id = entityMetaObj.getString("id");
//			web.setId(id);
//			String email = entityMetaObj.getString("email");
//			web.setEmail(email);
//			String amount = entityMetaObj.getString("amount");
//			web.setAmount(amount);
//			String orderId = entityMetaObj.getString("order_id");
//			web.setOrderID(orderId);
//			String notesObj = entityMetaObj.getString("notes");
//			JSONObject notesJsonObj = new JSONObject(notesObj);
//			String receiptNo = notesJsonObj.getString("shopping_order_id");
//			web.setReceiptNo(receiptNo);
//			String responseRecieved = json.toString();
//			web.setResonse(responseRecieved);
			String accountId = json.get("account_id").toString();
			web.setAccountId(accountId);
			String responseRecieved = json.toString();
			web.setResonse(responseRecieved);
			webhookResponseService.saveWebhookResponse(web);
			
		} catch (Exception e) {
			log.error("execption occured while save webhook ",e);
			WebhookResponse web=new WebhookResponse();
			String responseRecieved = json.toString();
			web.setResonse(responseRecieved);
			webhookResponseService.saveWebhookResponse(web);
		}
	}
}
