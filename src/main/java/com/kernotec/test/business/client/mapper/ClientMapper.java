package com.kernotec.test.business.client.mapper;

import com.kernotec.test.business.client.dto.ClientDto;
import com.kernotec.test.business.client.entity.Client;
import com.kernotec.test.mapper.IMapper;
import org.springframework.stereotype.Service;

@Service
public class ClientMapper implements IMapper<Client, ClientDto> {

	@Override
	public ClientDto toDto(Client entity) {
		return new ClientDto(entity.getName(), entity.getSurname1(), entity.getSurname2(), entity.getClassDocumentId(),
				entity.getNumberDocument(), entity.getBirthday(), entity.getGenderId(), entity.getStatus());
	}

	@Override
	public Client toEntity(ClientDto dto, boolean isNew) {
		return new Client(dto.getName(), dto.getSurname1(), dto.getSurname2(), dto.getClassDocumentId(),
				dto.getNumberDocument(), dto.getBirthday(), dto.getGenderId(), dto.getStatus());
	}
}
