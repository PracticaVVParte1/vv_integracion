package com.practica.integracion;

import com.practica.integracion.DAO.AuthDAO;
import com.practica.integracion.DAO.GenericDAO;
import com.practica.integracion.DAO.User;
import com.practica.integracion.manager.SystemManager;
import com.practica.integracion.manager.SystemManagerException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

// import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

	@ExtendWith(MockitoExtension.class)
	public class TestInvalidUser {
		// Crea una instancia de data service
		@Mock
		private GenericDAO dataService;
		@Mock
		private AuthDAO authdao;
		@Test
		public void testStartRemoteSystemWithInvalidUserAndSystem1() throws OperationNotSupportedException, SystemManagerException {
			User validUser = new User("76","Rosa","Lopez","Madrid",
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
			Collection<Object> retorno = manager.startRemoteSystem(validUser.getId(), "40");
			assertEquals(retorno.toString(), "[uno, dos]");
			// Comprobar que las llamadas a las dao se ejecutan y perimero la de autenticación y luego
			// la de acceso a datos
			ordenado.verify(authdao).getAuthData(validUser.getId());
			ordenado.verify(dataService).getSomeData(validUser, "where id=" + validId);
		}
		@Test
		public void testStartRemoteSystemWithInvalidUserAndSystem2() throws OperationNotSupportedException, SystemManagerException {
			User validUser = new User("76","Rosa","Lopez","Madrid",
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
			Collection<Object> retorno = manager.startRemoteSystem("75", validId);
			assertEquals(retorno.toString(), "[uno, dos]");
			// Comprobar que las llamadas a las dao se ejecutan y perimero la de autenticación y luego
			// la de acceso a datos
			ordenado.verify(authdao).getAuthData(validUser.getId());
			ordenado.verify(dataService).getSomeData(validUser, "where id=" + validId);
	}
		@Test
		public void testStartRemoteSystemWithInvalidUserAndSystem3() throws OperationNotSupportedException, SystemManagerException {
			User validUser = new User("76","Rosa","Lopez","Madrid",
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
			Collection<Object> retorno = manager.startRemoteSystem("75", "75");
			assertEquals(retorno.toString(), "[uno, dos]");
			// Comprobar que las llamadas a las dao se ejecutan y perimero la de autenticación y luego
			// la de acceso a datos
			ordenado.verify(authdao).getAuthData(validUser.getId());
			ordenado.verify(dataService).getSomeData(validUser, "where id=" + validId);
		}
		@Test
		public void testStopRemoteSystemWithInvalidUserAndSystem1() throws OperationNotSupportedException, SystemManagerException {
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
			Collection<Object> retorno = manager.startRemoteSystem(validUser.getId(), "75");
			assertEquals(retorno.toString(), "[uno, dos]");
			// Comprobar que las llamadas a las dao se ejecutan y perimero la de autenticación y luego
			// la de acceso a datos
			ordenado.verify(authdao).getAuthData(validUser.getId());
			ordenado.verify(dataService).getSomeData(validUser, "where id=" + validId);
		}
		@Test
		public void testStopRemoteSystemWithInvalidUserAndSystem2() throws OperationNotSupportedException, SystemManagerException {
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
			Collection<Object> retorno = manager.startRemoteSystem("75", validId);
			assertEquals(retorno.toString(), "[uno, dos]");
			// Comprobar que las llamadas a las dao se ejecutan y perimero la de autenticación y luego
			// la de acceso a datos
			ordenado.verify(authdao).getAuthData(validUser.getId());
			ordenado.verify(dataService).getSomeData(validUser, "where id=" + validId);
		}
		@Test
		public void testStopRemoteSystemWithInvalidUserAndSystem3() throws OperationNotSupportedException, SystemManagerException {
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
			Collection<Object> retorno = manager.startRemoteSystem("75", "75");
			assertEquals(retorno.toString(), "[uno, dos]");
			// Comprobar que las llamadas a las dao se ejecutan y perimero la de autenticación y luego
			// la de acceso a datos
			ordenado.verify(authdao).getAuthData(validUser.getId());
			ordenado.verify(dataService).getSomeData(validUser, "where id=" + validId);
		}
}
