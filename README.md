# API Cadastro Cliente

Aplicação utilizando Spring Boot com Rest Template

# Uso

É possível usar os métodos POST, PUT, DELETE, GET

# POST
__Adicionar um Cliente__

curl -X POST https://a4272d3e-f68f-4816-948b-9deda6c76b9e-00-3ck5elr1uvk17.spock.replit.dev:3000/api/v1/cliente/criar -H "Content-Type: application/json" -d '{"nome": "Nome do Cliente"}'

# PUT
__Alterar um Cliente__

curl -X PUT https://a4272d3e-f68f-4816-948b-9deda6c76b9e-00-3ck5elr1uvk17.spock.replit.dev:3000/api/v1/cliente/atualizar/{id} -H "Content-Type: application/json" -d '{"nome": "Nome do Cliente"}'

# DELETE
__Excluir um Cliente__

curl -X DELETE https://a4272d3e-f68f-4816-948b-9deda6c76b9e-00-3ck5elr1uvk17.spock.replit.dev:3000/api/v1/cliente/deletar/{id} -H "Content-Type: application/json"

# GET
__Buscar um Cliente__

curl -X GET https://a4272d3e-f68f-4816-948b-9deda6c76b9e-00-3ck5elr1uvk17.spock.replit.dev:3000/api/v1/cliente/get/{id} -H "Content-Type: application/json"

# GET
__Listar os Clientes__

curl -X GET https://a4272d3e-f68f-4816-948b-9deda6c76b9e-00-3ck5elr1uvk17.spock.replit.dev:3000/api/v1/cliente/listar -H "Content-Type: application/json"


