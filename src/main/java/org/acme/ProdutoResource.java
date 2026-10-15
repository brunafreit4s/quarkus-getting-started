package org.acme;

import java.util.List;

import entity.Produto;
import entity.dto.ProdutoDTO;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {
    
    /**
     * Retorna todos os produtos cadastrados
     * @return Lista de produtos
     */
    @GET
    public List<Produto> listaProdutos() {
        return Produto.listAll();
    }

    @GET
    @Path("/{id}")
    public Produto consultaProduto(@PathParam("id") Long id) {
        return Produto.findById(id);
    }

    /**
     * Cadastra um novo produto
     * @param dto Dados do produto a ser cadastrado
     * @return Response com o resultado da operação
     */
    @POST
    @Transactional
    public Response cadastra(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.nome = dto.nome;
        produto.descricao = dto.descricao;
        produto.preco = dto.preco;
        produto.persist();
        return Response.status(Response.Status.CREATED).build();
    }

    /**
     * Atualiza um produto existente
     * @param id ID do produto a ser atualizado
     * @param dto Dados atualizados do produto
     * @return Response com o resultado da operação
     */
    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualiza(@PathParam("id") Long id, ProdutoDTO dto) {
        Produto produto = Produto.findById(id);
        
        if (produto == null) return Response.status(Response.Status.NOT_FOUND).build();        

        produto.nome = dto.nome;
        produto.descricao = dto.descricao;
        produto.preco = dto.preco;
        produto.persist();
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleta(@PathParam("id") Long id) {
        Produto produto = Produto.findById(id);
        
        if (produto == null) return Response.status(Response.Status.NOT_FOUND).build();        

        produto.delete();
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}