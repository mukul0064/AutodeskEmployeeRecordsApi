package com.autodesk.service;

//Author's email address: mukul0064@gmail.com

import javax.validation.Valid;

import com.autodesk.model.DeleteRequestEvent;

public interface RecordDeleteService {
	String RecordDeleteServiceMethod(@Valid DeleteRequestEvent deleteRequestEvent);

}
