package cl.prueba.globalLogic.in;

import cl.prueba.globalLogic.util.Constantes;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
public class PhoneRequest {

	@Schema(name = Constantes.Request.PHONE_NUMBER, description = "Numero de telefono.", required = false)
	private long number;
	@Schema(name = Constantes.Request.PHONE_CITYCODE, description = "Codigo de ciudad.", required = false)
	private int citycode;
	@Schema(name = Constantes.Request.PHONE_CONTRYCODE, description = "Codigo de pais.", required = false)
	private String contrycode;
	
}
