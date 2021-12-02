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

// import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

	@ExtendWith(MockitoExtension.class)
	public class TestInvalidUser {
		// Crea una instancia de data service

		@Mock
		private GenericDAO dataService;
		@Mock
		private AuthDAO authdao;

		@DisplayName("PruebaStartRemoteSystemInvalid")
		@Test
		public void pruebaStartRemoteSystemWithInvalidUserAndSystem() throws OperationNotSupportedException, SystemManagerException {
			User validUser = new User("76","Rosa","Lopez","Madrid",
					new ArrayList<>(Arrays.asList(1, 2)));
			when(authdao.getAuthData(validUser.getId())).thenReturn(validUser);

			String validId = "12345";
			when(dataService.getSomeData(validUser, "where id=" + validId)).thenThrow(new OperationNotSupportedException()) ;
			// Se ejecuta la llamada al authdao
			// ahora se ejecuta el dao a acceso a datos del sistema
			InOrder ordenado = inOrder(authdao, dataService);
			// se instancia el manager con los mock creados
			SystemManager manager = new SystemManager(authdao, dataService);
			// Se llama a la api que queremos probar, en este caso SystemManager
			assertThrows(SystemManagerException.class, () -> manager.startRemoteSystem(validUser.getId(), validId));
			// Comprobar que las llamadas a las dao se ejecutan y perimero la de autenticación y luego
			// la de acceso a datos
			ordenado.verify(authdao).getAuthData(validUser.getId());
			ordenado.verify(dataService).getSomeData(validUser, "where id=" + validId);
		}

		@DisplayName("PruebaStopRemoteSystemInvalid")
		@Test
		public void pruebaStopRemoteSystemWithInvalidUserAndSystem() throws OperationNotSupportedException, SystemManagerException {
			User validUser = new User("76","Rosa","Lopez","Madrid",
					new ArrayList<>(Arrays.asList(1, 2)));
			when(authdao.getAuthData(validUser.getId())).thenReturn(validUser);

			String validId = "12345";
			when(dataService.getSomeData(validUser, "where id=" + validId)).thenThrow(new OperationNotSupportedException()) ;
			// Se ejecuta la llamada al authdao
			// ahora se ejecuta el dao a acceso a datos del sistema
			InOrder ordenado = inOrder(authdao, dataService);
			// se instancia el manager con los mock creados
			SystemManager manager = new SystemManager(authdao, dataService);
			// Se llama a la api que queremos probar, en este caso SystemManager
			assertThrows(SystemManagerException.class, () -> manager.stopRemoteSystem(validUser.getId(), validId));
			// Comprobar que las llamadas a las dao se ejecutan y perimero la de autenticación y luego
			// la de acceso a datos
			ordenado.verify(authdao).getAuthData(validUser.getId());
			ordenado.verify(dataService).getSomeData(validUser, "where id=" + validId);
		}

		@DisplayName("PruebaAddRemoteSystemInvalid1")
		@Test
		public void pruebaAddRemoteSystemInvalid1() throws OperationNotSupportedException, SystemManagerException {
			User validUser = new User("1","Ana","Lopez","Madrid",
					new ArrayList<>());
			when(authdao.getAuthData(validUser.getId())).thenReturn(validUser);

			String validId = "12345";
			ArrayList<Object> lista = new ArrayList<>(Arrays.asList("3","4"));
			when(dataService.updateSomeData(validUser,lista)).thenReturn(false);

			// Se ejecuta la llamada al authdao
			// ahora se ejecuta el dao a acceso a datos del sistema
			InOrder ordenado = inOrder(authdao, dataService);
			// se instancia el manager con los mock creados
			SystemManager manager = new SystemManager(authdao, dataService);
			// Se llama a la api que queremos probar, en este caso SystemManager
			assertThrows(SystemManagerException.class, () -> manager.addRemoteSystem(validUser.getId(),lista));
			// assertEquals(retorno.toString(), "[uno, dos]");
			// Comprobar que las llamadas a las dao se ejecutan y perimero la de autenticación y luego
			// la de acceso a datos
			ordenado.verify(authdao).getAuthData(validUser.getId());
			ordenado.verify(dataService).updateSomeData(validUser,lista);
		}

		@DisplayName("PruebaAddRemoteSystemInvalid2")
		@Test
		public void pruebaAddRemoteSystemInvalid2() throws OperationNotSupportedException, SystemManagerException {
			User validUser = new User("1","Ana","Lopez","Madrid",
					new ArrayList<>());
			when(authdao.getAuthData(validUser.getId())).thenReturn(validUser);

			String validId = "12345";
			ArrayList<Object> lista = new ArrayList<>(Arrays.asList("3","4"));
			when(dataService.updateSomeData(validUser,lista)).thenThrow(new OperationNotSupportedException()) ;

			// Se ejecuta la llamada al authdao
			// ahora se ejecuta el dao a acceso a datos del sistema
			InOrder ordenado = inOrder(authdao, dataService);
			// se instancia el manager con los mock creados
			SystemManager manager = new SystemManager(authdao, dataService);
			// Se llama a la api que queremos probar, en este caso SystemManager
			assertThrows(SystemManagerException.class, () -> manager.addRemoteSystem(validUser.getId(),lista));
			// assertEquals(retorno.toString(), "[uno, dos]");
			// Comprobar que las llamadas a las dao se ejecutan y perimero la de autenticación y luego
			// la de acceso a datos
			ordenado.verify(authdao).getAuthData(validUser.getId());
			ordenado.verify(dataService).updateSomeData(validUser,lista);
		}

		@DisplayName("PruebaDeleteRemoteSystemInvalid1")
		@Test
		public void pruebaDeleteRemoteSystemInvalid1() throws OperationNotSupportedException, SystemManagerException {
			User validUser = new User("1","Ana","Lopez","Madrid",
					new ArrayList<>());
			when(authdao.getAuthData(validUser.getId())).thenReturn(validUser);

			String validId = "12345";
			ArrayList<Object> lista = new ArrayList<>(Arrays.asList("3","4"));
			when(dataService.deleteSomeData(validUser, validId)).thenReturn(false);

			// Se ejecuta la llamada al authdao
			// ahora se ejecuta el dao a acceso a datos del sistema
			InOrder ordenado = inOrder(authdao, dataService);
			// se instancia el manager con los mock creados
			SystemManager manager = new SystemManager(authdao, dataService);
			// Se llama a la api que queremos probar, en este caso SystemManager
			assertThrows(SystemManagerException.class, () -> manager.deleteRemoteSystem(validUser.getId(),validId));
			// assertEquals(retorno.toString(), "[uno, dos]");
			// Comprobar que las llamadas a las dao se ejecutan y perimero la de autenticación y luego
			// la de acceso a datos
			ordenado.verify(authdao).getAuthData(validUser.getId());
			ordenado.verify(dataService).deleteSomeData(validUser,validId);
		}

		@DisplayName("PruebaDeleteRemoteSystemInvalid2")
		@Test
		public void pruebaDeleteRemoteSystemInvalid2() throws OperationNotSupportedException, SystemManagerException {
			User validUser = new User("1","Ana","Lopez","Madrid",
					new ArrayList<>());
			when(authdao.getAuthData(validUser.getId())).thenReturn(validUser);

			String validId = "12345";
			ArrayList<Object> lista = new ArrayList<>(Arrays.asList("3","4"));
			when(dataService.deleteSomeData(validUser,validId)).thenThrow(new OperationNotSupportedException()) ;

			// Se ejecuta la llamada al authdao
			// ahora se ejecuta el dao a acceso a datos del sistema
			InOrder ordenado = inOrder(authdao, dataService);
			// se instancia el manager con los mock creados
			SystemManager manager = new SystemManager(authdao, dataService);
			// Se llama a la api que queremos probar, en este caso SystemManager
			assertThrows(SystemManagerException.class, () -> manager.deleteRemoteSystem(validUser.getId(),validId));
			// assertEquals(retorno.toString(), "[uno, dos]");
			// Comprobar que las llamadas a las dao se ejecutan y perimero la de autenticación y luego
			// la de acceso a datos
			ordenado.verify(authdao).getAuthData(validUser.getId());
			ordenado.verify(dataService).deleteSomeData(validUser,validId);
		}
}
