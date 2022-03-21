// Para Criar uma tabela do zero

db.createColletion("alunos")

// Para inserir dados na tabela ( alunos )

db.alunos.insert(
{
nome : "Daniela",
data_nascimento : new Date(1995,09,30),
curso : {
"nome" : "Moda"
},
habilidades : [
{
	nome : "Alemão",
	nível : "basico"
}
]
}
)

// Para remover um item da tabela

db.alunos.remove({
	"_id" : ObjectId("62389be15f843a7a87432bc2")
})

// Para procurar mais de um curso pelo nome [or]

db.alunos.find({
$or : [
{"curso.nome" : "Sistemas de informação"},
{"curso.nome" : "Engenharia Quimica"},
{"curso.nome" : "Moda"}
]
})

// Para procurar um aluno no meio desses cursos [or]
db.alunos.find({
$or : [
{"curso.nome" : "Sistemas de informação"},
{"curso.nome" : "Engenharia Quimica"},
{"curso.nome" : "Moda"}
],
"nome" : "Daniela"
})

// Para procurar um aluno no meio desses cursos [in]

db.alunos.find({
	"curso.nome" : {
		$in : ["Sistemas de informação", "Engenharia Quimica"]
	}
})

// Para substituir somente um campo do documento basta usar o operador $set passando um json com o campo e o novo valor

db.alunos.update(
	{"curso.nome" : "Sistemas de informação"},
	{
		$set : {
			"curso.nome" : "Sistemas de Informação"	
		}
	}
)

// Por padrão o método update só atualiza um documento, para que ele atualize mais de um precisamos passar também o parâmetro multi:true

db.alunos.update(
	{"curso.nome" : "Sistemas de informação"},
	{
		$set : {
			"curso.nome" : "Sistemas de Informação"	
		}
	}, {
		multi : true
	}
)

// Para adicionar um valor a um array já existente usamos o operador $push
db.alunos.update(
	{"_id" : ObjectId("62389be15f843a7a87432bc2")},
	{
		$push : {
			notas : 8.5
		}
	}
)

// Para adicionar mais de um valor a um array já existente usamos o modificador $each em conjunto com o operador $push

db.alunos.update(
	{"_id" : ObjectId("62389be15f843a7a87432bc2")},
	{
		$push : {
			notas : { $each : [8.5, 3] }
		}
	}
)

// Tras as notas maiores ou igual a 5 (>=5)
db.alunos.find({
	notas : {$gt : 5}
})

// Tras as notas menores ou igual a 5 (<=5)
db.alunos.find({
	notas : {$lt : 5}
})

// Tras apenas a nota de uma pessoa

db.alunos.findOne({
	notas : { $gt : 5}
})

// Ordenar em forma alfabetica [crescente]

db.alunos.find().sort({"nome" : 1})

// Ordenar em forma alfabetica [decrescente]

db.alunos.find().sort({"nome" : -1})

// Ordenar em forma alfabetica [crescente] e limitando apenas 3 nomes

db.alunos.find().sort({"nome" : 1}).limit(3)

// Adicionando campo Localização no id desejado
db.alunos.update(
{"_id" : ObjectId("62389be15f843a7a87432bc2")},
{
	$set : {
		localizacao : {
			endereco: "Rua Vergueiro, 3185",
			cidade: "São Paulo",
			pais : "Brasil",
			coordinates: [-23.588213, -46.632356],
			type: "Point"
		}
	}
})

// Agrega a pessoa mais proxima da coordenada [-23.588213, -46.632356]
//Para limitar a quantidade precisamos passar o campo num: quantidade
// comando {$skip : 1} ignora a primeira pessoa

db.alunos.aggregate([
{
	$geoNear : {
		near : {
			coordinates: [-23.588213, -46.632356],
			type: "Point"
		},
		distanceField : "distancia.calculada",
		spherical : true,
		num : 4
	}
},
{ $skip : 1}
])

//Criando index para Localização considerando ela como uma esfera 2d

db.alunos.createIndex({
	localizacao : "2dsphere"
})