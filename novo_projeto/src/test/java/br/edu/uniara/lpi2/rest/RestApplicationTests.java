package br.edu.uniara.lpi2.rest;

import br.edu.uniara.lpi2.rest.controller.EmployeeController;
import br.edu.uniara.lpi2.rest.model.Employee;
import br.edu.uniara.lpi2.rest.model.EmployeeRepository;
import br.edu.uniara.lpi2.rest.model.EmployeePaginRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EmployeeControllerTest {

	@Mock
	private EmployeeRepository repository;

	@Mock
	private EmployeePaginRepository paginRepository;

	@InjectMocks
	private EmployeeController controller;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testAll() {
		// Este teste está projetado para falhar
		when(repository.findAll()).thenReturn(List.of(new Employee("John Doe", "developer")));

		List<Employee> employees = controller.all();

		assertEquals(2, employees.size(), "O tamanho da lista de funcionários deve ser 2");
	}

	@Test
	void testOne() {
		// Este teste está projetado para falhar
		when(repository.findById(1L)).thenReturn(Optional.of(new Employee("John Doe", "developer")));

		Employee foundEmployee = controller.one(1L);

		assertNull(foundEmployee, "O funcionário deve ser nulo");
	}
}
