const form = document.getElementById("formulario");

form.addEventListener("submit", event =>{
    event.preventDefault();

    const formData = new FormData(form);
    const data = Object.fromEntries(formData);

    fetch("http://localhost:8080/api/estoque/produtos", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    }).then(res => res.json()).then(data => console.log(data)).catch(error => console.log(error));
});

function mensagem(){
    alert("Produto cadastrado com sucesso!")
    window.location.reload(true);
}

fetch("http://localhost:8080/api/estoque/produtos").then((data)=>{
    return data.json();
  }).then((todosProdutos) =>{
      let data1 = "";
      todosProdutos.map((values) =>{
          data1 += `
          <tbody>
              <tr>
                  <th scope="row">${values.id} </td>
                  <td>${values.nome}</td> 
                  <td>${values.marca}</td> 
                  <td>${values.quantidade} </td>
                  <td>R$ ${values.valorUnitario}</td> 
              </tr>
          </tbody>
          `
      })
      document.getElementById("produtosDados").innerHTML = data1;
      console.log(todosProdutos);
  })

  

  /*function buscarProduto(){
    const produtoId = document.getElementById("produtoId").value;

  fetch("http://localhost:8080/api/estoque/produtos/${produtoId}",{
    method:'GET',
    headers: {
        'Content-Type': 'aplication/json'
    }
  })
  .then(response => response.json())
  .then((data) => {
    const resultadoDiv = document.getElementById("resultado");
    resultadoDiv.innerHTML = `
    <h4>Produto encontrado</h4>
    <p>Id: ${data.id}</p>
    <p>Nome: ${data.nome}</p>
    <p>Quantidade: ${data.quantidade}</p>
    <p>Preco: ${data.valorUnitario}</p>
    `;
  }).catch(error => {
    console.error("Erro ao buscar o produto.")
    const resultadoDiv = document.getElementById("resultado");
    resultadoDiv.innerHTML= '<p>Produto não encontrado.</p>';
  });
  }*/
