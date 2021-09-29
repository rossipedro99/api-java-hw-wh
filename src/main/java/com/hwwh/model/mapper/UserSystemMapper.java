package com.hwwh.model.mapper;

import org.springframework.stereotype.Service;

import com.hwwh.model.UserSystemModel;
import com.hwwh.model.dto.UserSystemDTO;

@Service
public class UserSystemMapper {
	
	public UserSystemModel mapUserSystemDTO(UserSystemDTO dto) {
		UserSystemModel user = new UserSystemModel(dto.getIdUsuario(),dto.getSistemaOperacional(),dto.getProcessador(),dto.getPlacaDeVideo(),dto.getPlacaMae(),dto.getHd(), dto.getMemoriaRam(),dto.getCpuID(),dto.getBaseBoardID(),dto.getHdID(),dto.getRamID(),dto.getGpuID());
		return user;
	}

}
