package javarefresh;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javarefresh.model.DoctorXMLBean;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
class SpringBootDefinedPortTests {

	@Autowired
	private TestRestTemplate template;

	// No use of port as it will give 0 value if WebEnvironment.RANDOM_PORT
	// If you define the WebEnvironment.DEFINED_PORT then it will give you 8080
	@Value("${local.server.port}")
	int randomServerPort;

	// throw Exception
	// @Autowired
	// Environment environment;
	// String port = environment.getProperty("local.server.port");

	String path = "http://localhost:";

	@BeforeEach
	public void setup() {
		// Nothing to set
	}

	@Test
	public void testFindAllDoctorsInXML() throws Exception {
		path = path + randomServerPort + "/doctorApp/doctorsInXML";
		ParameterizedTypeReference<List<DoctorXMLBean>> myBean = new ParameterizedTypeReference<List<DoctorXMLBean>>() {
		};
		ResponseEntity<List<DoctorXMLBean>> response = template.exchange(path, HttpMethod.GET, null, myBean);
		// INSERT INTO doctor(id, name, register_id) VALUES(3, 'Rahul', 287);
		DoctorXMLBean bean = new DoctorXMLBean();
		bean.setId(3L);
		bean.setName("Rahul");
		bean.setRegisterId(287);
		assertThat(response.getBody()).contains(bean);
	}

	@Test
	public void oneCity() {
		// INSERT INTO doctor(id, name, register_id) VALUES(4, 'Yogesh', 940);
		path = path + randomServerPort + "/doctorApp/doctorInXML";
		DoctorXMLBean doctor = this.template.getForObject(path + "/4/", DoctorXMLBean.class);
		assertThat(doctor).extracting("name", "registerId").containsExactly("Yogesh", 940);
	}

}
