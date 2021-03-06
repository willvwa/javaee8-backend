package br.dev.willvwa.controlador;

import br.dev.willvwa.entidade.Paciente;
import br.dev.willvwa.negocio.PacienteNegocio;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/paciente")
public class PacienteControlador extends Controlador<Paciente> {

    @Inject
    private PacienteNegocio pacienteNegocio;

    @GET
    @Path("/obter")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Paciente> obterTodos() {

        try {

            return this.pacienteNegocio.obterTodos();

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }

    @GET
    @Path("/excluir/{pacienteId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void excluir(@PathParam("pacienteId") Long pacienteId) {

        try {

            this.pacienteNegocio.excluir(pacienteId);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @POST
    @Path("/salvar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void salvar(Paciente paciente) {

        try {

            this.pacienteNegocio.salvar(paciente);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}
