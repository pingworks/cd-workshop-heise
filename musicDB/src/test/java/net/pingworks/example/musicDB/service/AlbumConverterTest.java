package net.pingworks.example.musicDB.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import junit.framework.Assert;
import net.pingworks.example.musicDB.bo.AlbumBO;
import net.pingworks.example.musicDB.dto.AlbumDTO;

import org.junit.Before;
import org.junit.Test;

public class AlbumConverterTest {
	
	private AlbumConverter testee;
	
	@Before
	public void setUp() {
		testee = new AlbumConverter();
	}

	@Test
	public void testConvertToBO() {
		AlbumDTO dtoMock = mock(AlbumDTO.class);
		when(dtoMock.getArtist()).thenReturn("Super artist");
		
		AlbumBO bo = testee.convertToBO(dtoMock);
		Assert.assertEquals("Super artist", bo.getArtist());
	}

	@Test
	public void testConvertToDTOAlbumBO() {
		AlbumBO boMock = mock(AlbumBO.class);
		when(boMock.getArtist()).thenReturn("Heino");
		
		AlbumDTO dto = testee.convertToDTO(boMock);
		Assert.assertEquals("Heino", dto.getArtist());
	}

}
