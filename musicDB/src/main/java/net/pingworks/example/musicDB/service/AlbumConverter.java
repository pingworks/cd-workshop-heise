package net.pingworks.example.musicDB.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import net.pingworks.example.musicDB.bo.AlbumBO;
import net.pingworks.example.musicDB.dto.AlbumDTO;

@ManagedBean
@ApplicationScoped
public class AlbumConverter {

	public AlbumBO convertToBO(AlbumDTO dto) {
		AlbumBO bo = new AlbumBO();
		bo.setId(dto.getId());
		bo.setArtist(dto.getArtist());
		bo.setTitle(dto.getTitle());
		return bo;
	}

	public AlbumDTO convertToDTO(AlbumBO bo) {
		AlbumDTO dto = new AlbumDTO();
		dto.setId(bo.getId());
		dto.setArtist(bo.getArtist());
		dto.setTitle(bo.getTitle());
		return dto;
	}

	public List<AlbumDTO> convertToDTO(List<AlbumBO> boList){
		List<AlbumDTO> dtoList = new ArrayList<AlbumDTO>();
		for (AlbumBO albumBO : boList) {
			dtoList.add(convertToDTO(albumBO));
		}
		return dtoList; 
	}
}
