# Exercício: Criar uma API de Varejo Local com Spring Boot, Java 21, Spring Data JPA e H2 Database
## Objetivos
- Desenvolver uma API de varejo local que gerencie clientes, pedidos e itens de pedidos, com todas as entidades associadas entre si utilizando Java e Spring/Spring JPA
- Utilizar o MySQL para persistir as entidades
- Subir o MySQL no Docker
# Requisitos:

### Entidades:
- Cliente: representa os clientes da loja.
- Pedido: representa os pedidos realizados pelos clientes.
- Produto: representa os produtos disponíveis no estoque.
- ItemPedido: representa os itens de cada pedido.
### Associações: 
- Um cliente pode ter vários pedidos. 
- Um pedido pode ter vários itens de pedido.
- Cada item de pedido está associado a um produto.


