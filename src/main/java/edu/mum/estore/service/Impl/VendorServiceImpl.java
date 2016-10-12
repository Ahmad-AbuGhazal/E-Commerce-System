package edu.mum.estore.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.mum.estore.domain.RequestedCard;
import edu.mum.estore.domain.ResponseInfo;
import edu.mum.estore.domain.Vendor;
import edu.mum.estore.repository.VendorRepository;
import edu.mum.estore.rest.RemoteApi;
import edu.mum.estore.service.VendorService;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {
	
	@Autowired
	private RemoteApi remoteApi;
	
	@Autowired
	private VendorRepository vendorRepository;

	@Override
	public ResponseInfo addVendor(Vendor vendor) {
		ResponseInfo responseInfo = new ResponseInfo();
		if(checkROC(vendor) && verifyPayment(vendor)) {
			/*RestTemplate restTemplate = remoteApi.getRestTemplate();
			HttpEntity<Vendor> httpEntity = new HttpEntity<Vendor>(vendor, remoteApi.getHttpHeaders());
			ResponseEntity<Vendor> response = restTemplate.exchange("http://localhost:8080/estore/addVendor", HttpMethod.POST, httpEntity, 
										Vendor.class);*/
			
			vendorRepository.addVendor(vendor);
			
			responseInfo.setResponse('Y');
			return responseInfo;
		}
		responseInfo.setResponse('N');
		return responseInfo;
	}

	@Override
	public Vendor searchVendor(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vendor> getVendors() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static final String rocUrl = "http://localhost:8080/eroc/api/numbers/{vendor_id}";
	private static final String paymentUrl = "http://localhost:8080/epayment/afterplaceorder";

	private boolean checkROC(Vendor vendor) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		HttpEntity<Vendor> httpEntity = new HttpEntity<Vendor>(vendor, remoteApi.getHttpHeaders());
		ResponseEntity<String> response = restTemplate.exchange(rocUrl, HttpMethod.GET, httpEntity, String.class,
											vendor.getVendor_id());
		
		if(response!=null && response.getBody().equalsIgnoreCase("YES"))
			return true;
		else 
			return false;
	}
	
	private boolean verifyPayment(Vendor vendor) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		HttpEntity<RequestedCard> httpEntity = new HttpEntity<RequestedCard>(vendor.getRequestedCard(), remoteApi.getHttpHeaders());
		ResponseEntity<ResponseInfo> response = restTemplate.exchange(paymentUrl, HttpMethod.POST, httpEntity, ResponseInfo.class);
		if(response!=null && response.getBody().getResponse()=='Y')
			return true;
		else 
			return false;
	}

}
