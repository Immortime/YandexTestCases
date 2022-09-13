package com.restservice;

import com.restservice.model1.*;
import com.restservice.model2.Attribute2;
import com.restservice.model2.FindByCriteriaRequest;
import com.restservice.model2.FindByCriteriaResponse;
import com.restservice.model2.TypedObjects;
import com.restservice.model3.Attribute3;
import com.restservice.model3.DeleteSotrudnikRequest;
import com.restservice.model3.DeleteSotrudnikResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class SotrudnikController {

	private CreateSotrudnikResponse fillTheAttributes() {
		CreateSotrudnikResponse create = new CreateSotrudnikResponse();
		create.attributes1 = new ArrayList<>();
		Attribute1 FIO = new Attribute1("FIO", "Дуайт Шрут");
		Attribute1 object_id = new Attribute1("object_id", "User_7");
		Attribute1 appointment = new Attribute1("appointment", "Менеджер на телефоне");
		Attribute1 Filial_name = new Attribute1("Filial_name", "Рога и копыта");
		Attribute1 is_deleted = new Attribute1("is_deleted", "false");
		create.attributes1.add(FIO);
		create.attributes1.add(object_id);
		create.attributes1.add(appointment);
		create.attributes1.add(Filial_name);
		create.attributes1.add(is_deleted);
		return create;
	}

	private FindByCriteriaResponse fillTheTypeAndAttributes() {
		FindByCriteriaResponse find = new FindByCriteriaResponse();
		find.typedObjects = new ArrayList<>();
		TypedObjects type = new TypedObjects("Менеджер на телефоне", new ArrayList<>());
		find.typedObjects.add(type);
		Attribute2 FIO = new Attribute2("FIO", "Дуайт Шрут");
		Attribute2 object_id = new Attribute2("object_id", "User_7");
		Attribute2 appointment = new Attribute2("appointment", "Менеджер на телефоне");
		Attribute2 Filial_name = new Attribute2("Filial_name", "Рога и копыта");
		Attribute2 is_deleted = new Attribute2("is_deleted", "false");
		type.attributes.add(FIO);
		type.attributes.add(object_id);
		type.attributes.add(appointment);
		type.attributes.add(Filial_name);
		type.attributes.add(is_deleted);
		return find;
	}

	private DeleteSotrudnikResponse manageDeleteAttributes() {
		DeleteSotrudnikResponse delete = new DeleteSotrudnikResponse();
		delete.attributes1 = new ArrayList<>();
		Attribute3 deleted = new Attribute3("User_7", true);
		delete.attributes1.add(deleted);
		return delete;
	}

	@PostMapping("/createSotrudnik")
	public @ResponseBody CreateSotrudnikResponse createSotrudnik(@RequestBody CreateSotrudnikRequest request) {
		CreateSotrudnikResponse create = fillTheAttributes();
		return create;
	}


	@PostMapping("/findSotrudnik")
	public @ResponseBody FindByCriteriaResponse findSotrudnik(@RequestBody FindByCriteriaRequest request) {
		FindByCriteriaResponse find = fillTheTypeAndAttributes();
		return find;
	}

	@PostMapping("/deleteSotrudnik")
	public @ResponseBody DeleteSotrudnikResponse deleteSotrudnik(@RequestBody DeleteSotrudnikRequest request) {
		DeleteSotrudnikResponse delete = manageDeleteAttributes();
		return delete;
	}

}
