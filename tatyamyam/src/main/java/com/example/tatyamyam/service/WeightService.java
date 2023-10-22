package com.example.tatyamyam.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tatyamyam.entity.Weight;
import com.example.tatyamyam.form.WeightForm;
import com.example.tatyamyam.repository.WeightRepository;

@Service
public class WeightService {
	private final WeightRepository weightRepository;
	
	public WeightService(WeightRepository weightRepository) {
		this.weightRepository = weightRepository;
	}
	
	public void saveWeight(WeightForm weightForm) {
        Weight weight = new Weight();
        weight.setWeight(weightForm.getWeight());
		
        	//入れたい要素追加
        
        weightRepository.save(weight);
	}
	
	// コントローラクラスのweightSubmitメソッド内
	@PostMapping("/regist_weight")
	public String weightSubmit(WeightForm weightForm) {
	    System.out.println(weightForm.getWeight());

	    weightService.saveWeight(weightForm);

	    return "end";
	}

}
