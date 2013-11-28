package net.pingworks.example.musicDB.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import net.pingworks.example.musicDB.dto.AlbumDTO;
import net.pingworks.example.musicDB.service.AlbumService;

@ManagedBean
@RequestScoped
public class AlbumController {

	@ManagedProperty(value = "#{albumDTO}")
	private AlbumDTO album;

	@ManagedProperty(value = "#{albumService}")
	private AlbumService service;

	private List<AlbumDTO> albumList;

	private List<AlbumDTO> filteredAlbumList;

	public AlbumDTO getAlbum() {
		return album;
	}

	public void setAlbum(AlbumDTO album) {
		this.album = album;
	}

	public AlbumService getService() {
		return service;
	}

	public void setService(AlbumService service) {
		this.service = service;
	}

	private void clearLists() {
		albumList = null;
		filteredAlbumList = null;
	}

	public List<AlbumDTO> getAlbumList() {
		if (albumList == null) {
			albumList = service.getList();
		}
		return albumList;
	}

	public List<AlbumDTO> getFilteredAlbumList() {
		if (filteredAlbumList == null) {
			filteredAlbumList = getAlbumList();
		}
		return filteredAlbumList;
	}

	public void setFilteredAlbumList(List<AlbumDTO> dtoList) {
		filteredAlbumList = dtoList;
	}

	public void create() throws Exception {
		service.save(album);

		FacesMessage facesMessage = new FacesMessage("Album created: "
				+ album.toString());
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);

		clearLists();
	}

	public void delete(AlbumDTO album) {
		service.delete(album);

		FacesMessage facesMessage = new FacesMessage("Album deleted: "
				+ album.toString());
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);

		clearLists();
	}

	public void reset() throws Exception {
		service.resetRepo();

		FacesMessage facesMessage = new FacesMessage("Repo reset.");
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);

		clearLists();
	}
}
