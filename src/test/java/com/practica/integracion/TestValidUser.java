package com.practica.integracion;

import com.practica.integracion.DAO.AuthDAO;
import com.practica.integracion.DAO.GenericDAO;
import com.practica.integracion.DAO.User;
import com.practica.integracion.manager.SystemManager;
import com.practica.integracion.manager.SystemManagerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestValidUser {
	// Crea una instancia de data service
	@Mock
	private GenericDAO dataService;
	@Mock
	private AuthDAO authdao;

	@DisplayName("PruebaStartRemoteSystemValid")
	@Test
	public void pruebaStartRemoteSystemWithValidUserAndSystem() throws OperationNotSupportedException, SystemManagerException {
		User validUser = new User("1","Ana","Lopez","Madrid",
				new ArrayList<>(Arrays.asList(1, 2)));
		when(authdao.getAuthData(validUser.getId())).thenReturn(validUser);

		String validId = "12345";
		ArrayList<Object> lista = new ArrayList<>(Arrays.asList("uno","dos"));
		when(dataService.getSomeData(validUser, "where id=" + validId)).thenReturn(lista);
		// Se ejecuta la llmada al authdao
		// ahora se ejecuta el dao a acceso a datos del sistema
		InOrder ordenado = inOrder(authdao, dataService);
		// se instancia el manager con los mock creados
		SystemManager manager = new SystemManager(authdao, dataService);
		// Se llama a la api que queremos probar, en este caso SystemManager
		Collection<Object> retorno = manager.startRemoteSystem(validUser.getId(), validId);
		assertEquals(retorno.toString(), "[uno, dos]");
		// Comprobar que las llamadas a las dao se ejecutan y perimero la de autenticación y luego
		// la de acceso a datos
		ordenado.verify(authdao).getAuthData(validUser.getId());
		ordenado.verify(dataService).getSomeData(validUser, "where id=" + validId);
	}

	@DisplayName("PruebaStopRemoteSystemValid")
	@Test
	public void pruebaStopRemoteSystemWithValidUserAndSystem() throws OperationNotSupportedException, SystemManagerException {
		User validUser = new User("1","Ana","Lopez","Madrid",
				new ArrayList<>(Arrays.asList(1, 2)));
		when(authdao.getAuthData(validUser.getId())).thenReturn(validUser);

		String validId = "12345";
		ArrayList<Object> lista = new ArrayList<>(Arrays.asList("uno","dos"));
		when(dataService.getSomeData(validUser, "where id=" + validId)).thenReturn(lista);
		// Se ejecuta la llmada al authdao
		// ahora se ejecuta el dao a acceso a datos del sistema
		InOrder ordenado = inOrder(authdao, dataService);
		// se instancia el manager con los mock creados
		SystemManager manager = new SystemManager(authdao, dataService);
		// Se llama a la api que queremos probar, en este caso SystemManager
		Collection<Object> retorno = manager.startRemoteSystem(validUser.getId(), validId);
		assertEquals(retorno.toString(), "[uno, dos]");
		// Comprobar que las llamadas a las dao se ejecutan y perimero la de autenticación y luego
		// la de acceso a datos
		ordenado.verify(authdao).getAuthData(validUser.getId());
		ordenado.verify(dataService).getSomeData(validUser, "where id=" + validId);
	}

	@DisplayName("PruebaAddRemoteSystemValid")
	@Test
	public void testAddRemoteSystemValid() throws OperationNotSupportedException, SystemManagerException {
		User validUser = new User("1","Ana","Lopez","Madrid",
				new ArrayList<>());
		when(authdao.getAuthData(validUser.getId())).thenReturn(validUser);

		String validId = "12345";
		ArrayList<Object> lista = new ArrayList<>(Arrays.asList("3","4"));
		when(dataService.updateSomeData(validUser,lista)).thenReturn(true);

		// Se ejecuta la llmada al authdao
		// ahora se ejecuta el dao a acceso a datos del sistema
		InOrder ordenado = inOrder(authdao, dataService);
		// se instancia el manager con los mock creados
		SystemManager manager = new SystemManager(authdao, dataService);
		// Se llama a la api que queremos probar, en este caso SystemManager
		manager.addRemoteSystem(validUser.getId(),lista);
		// assertEquals(retorno.toString(), "[uno, dos]");
		// Comprobar que las llamadas a las dao se ejecutan y perimero la de autenticación y luego
		// la de acceso a datos
		ordenado.verify(authdao).getAuthData(validUser.getId());
		ordenado.verify(dataService).updateSomeData(validUser,lista);
	}

	@DisplayName("PruebaDeleteRemoteSystemValid")
	@Test
	public void testDeleteRemoteSystemValid() throws OperationNotSupportedException, SystemManagerException {
		User validUser = new User("1","Antonio","Perez","Madrid",
				new ArrayList<>());
		when(authdao.getAuthData(validUser.getId())).thenReturn(validUser);

		String validId = "1";
		ArrayList<Object> lista = new ArrayList<>(Arrays.asList("3","4"));
		when(dataService.deleteSomeData(validUser,validId)).thenReturn(true);
		// Se ejecuta la llmada al authdao
		// ahora se ejecuta el dao a acceso a datos del sistema
		InOrder ordenado = inOrder(authdao, dataService);
		// se instancia el manager con los mock creados
		SystemManager manager = new SystemManager(authdao, dataService);
		// Se llama a la api que queremos probar, en este caso SystemManager
		manager.deleteRemoteSystem(validUser.getId(),validId);
		// assertEquals(retorno.toString(), "[uno, dos]");
		// Comprobar que las llamadas a las dao se ejecutan y perimero la de autenticación y luego
		// la de acceso a datos
		ordenado.verify(authdao).getAuthData(validUser.getId());
		ordenado.verify(dataService).deleteSomeData(validUser,validId);
	}
}

