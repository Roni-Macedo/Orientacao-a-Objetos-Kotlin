import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.net.SocketTimeoutException

// ✅ Nível 1 — Fundamentos (Simples)
// 🟢 Exercício 1: Criar uma classe simples
// Crie uma classe Pessoa com os atributos nome e idade,
// e um metodo apresentar() que imprime "Olá, meu nome é X e tenho Y anos".

/**
 * Classe que representa uma pessoa com nome e idade.
 *
 * Exemplo de uso:
 * ```
 * val pessoa = Pessoa("Maria", 32) // instancia a classe Pessoa
 * pessoa.apresentar()              // chama o método apresentar()
 * ```
 */
class Pessoa(val nome: String, val idade: Int) {
    fun apresentar() {
        println("Olá, meu nome é $nome e tenho $idade anos")
    }
}

// 🟢 Exercício 2: Classe com construtor secundário
//Crie uma classe Produto com nome e preco,
// e um construtor secundário que permite
// criar um produto com preco = 0.0 por padrão.

/**
 * Representa um produto com nome e preço.
 * nome Nome do produto.
 * preco Preço do produto.
 *
 * Cria um [Produto] com nome e preço informados.
 * Cria um [Produto] com nome e preço padrão 0.0.
 *
 * Exemplo de uso:
 * ```
 * val p1 = Produto("Caneta", 2.50)  // usa o construtor primário
 * val p2 = Produto("Lápis")         // usa o construtor secundário com preco = 0.0
 * ```
 *
 * Construtor secundário que define o preço como 0.0 por padrão.
 *
 */
class Produto(val nome: String, val preco: Double) {
    constructor(nome: String) : this(nome, 0.0)
}

// 🟢 Exercício 3: Classe com metodo que altera o estado
// Crie uma classe ContaBancaria com saldo, e métodos
// depositar(valor: Double) e sacar(valor: Double).

/**
 * Representa uma conta bancária com um saldo atual.
 *
 * Exemplo de uso:
 * ```
 * var conta = ContaBancaria(100.0)
 * conta.depositar(50.0)
 * println(conta.saldo) // 150.0
 * conta.sacar(30.0)
 * println(conta.saldo) // 120.0
 * ```
 */
class ContaBancaria(var saldo: Double) {

    fun depositar(valor: Double) {
        if (valor > 0) {
            saldo += valor
        }

    }

    fun sacar(valor: Double) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor
        }
    }
}

// ✅ Nível 2 — Herança, Polimorfismo, Encapsulamento
// 🟡 Exercício 4: Herança e override
// Crie uma classe Animal com o metodo fazerSom(),
// e duas subclasses Cachorro e Gato que sobrescrevem esse metodo.

/**
 *  — Herança, Polimorfismo, Encapsulamento
 * Herança e override
 *
 * Este exercício demonstra o uso de herança em Kotlin, onde uma classe base chamada [Animal]
 * define um comportamento genérico através do metodo [fazerSom].
 * As classes [Cachorro] e [Gato] herdam de [Animal] e sobrescrevem o metodo [fazerSom] para
 * fornecer sons específicos para cada tipo de animal.
 *
 * Classes:
 * - Animal: Classe base com metodo genérico que pode ser sobrescrito.
 *
 * ```
 * open class Animal() {
 *     open fun fazerSom() {
 *         println("Som Generico do Animal")
 *     }
 * }
 * ```
 *
 * - Cachorro: Subclasse de Animal que representa um cachorro e emite um latido.
 *
 * ```
 * class Cachorro(): Animal() {
 *     override fun fazerSom() {
 *         println("Som do Cachorro Au Auuu...")
 *     }
 * }
 * ```
 *
 * - Gato: Subclasse de Animal que representa um gato e emite um miado.
 *
 * ```
 * class Gato(): Animal() {
 *     override fun fazerSom() {
 *         println("Som do Gato Miau Miauuu...")
 *     }
 * ```
 *
 * Métodos:
 * - fazerSom(): Metodo que representa o som do animal. É sobrescrito nas subclasses.
 *
 * Exemplo de uso:
 * ```
 * val cachorro = Cachorro()
 * cachorro.fazerSom() // Saída: Som do Cachorro: Au Auuu...
 *
 * val gato = Gato()
 * gato.fazerSom()     // Saída: Som do Gato: Miau Miauuu...
 * ```
 */
open class Animal() {
    open fun fazerSom() {
        println("Som Generico do Animal")
    }
}

class Cachorro() : Animal() {
    override fun fazerSom() {
        println("Som do Cachorro Au Auuu...")
    }
}

class Gato() : Animal() {
    override fun fazerSom() {
        println("Som do Gato Miau Miauuu...")
    }
}

// 🟡 Exercício 5: Modificadores de visibilidade
// Na classe ContaBancaria, torne o saldo private e
// crie um metodo público mostrarSaldo() para exibir o valor.

/**
 * Representa uma conta bancária com saldo protegido (encapsulado).
 *
 * O saldo é privado e só pode ser acessado ou alterado
 * por meio dos métodos públicos fornecidos pela classe.
 *
 * ```
 * private var saldo: Double
 * val conta = ContaBancaria(100.0)
 * conta.saldo = 200.0 // ❌ Isso não compila!
 *```
 *
 * Funcionalidades:
 * - mostrarSaldo(): retorna o valor atual do saldo.
 * - depositar(valor): adiciona um valor ao saldo, se for positivo.
 * - sacar(valor): subtrai um valor do saldo, se for positivo e não exceder o saldo disponível.
 *
 * Exemplo de uso:
 * ```
 * val conta = Conta_Bancaria(100.0)
 * conta.depositar(50.0)
 * conta.sacar(30.0)
 * println(conta.mostrarSaldo()) // Saída: 120.0
 * ```
 */
class Conta_Bancaria(private var saldo: Double) {

    fun mostrarSaldo(): Double {
        return saldo
    }

    fun depositar(valor: Double) {
        if (valor > 0) {
            saldo += valor
        }

    }

    fun sacar(valor: Double) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor
        }
    }
}

// 🟡 Exercício 6: Classe data
// Crie uma data class chamada Livro com os atributos titulo,
// autor e ano. Depois, compare dois livros com == e imprima o resultado.
/**
 * 🟡 Exercício 6: Classe data
 *
 * Esta atividade demonstra o uso de uma data class em Kotlin.
 *
 * A classe `Livro` é uma `data class` que representa um livro com três propriedades:
 * - `titulo`: o título do livro.
 * - `autor`: o autor do livro.
 * - `ano`: o ano de publicação.
 *
 * Objetivo:
 * Criar dois objetos da classe `Livro` com valores diferentes e compará-los usando `==`.
 * A comparação em `data class` verifica se os dados (valores dos atributos) são iguais,
 * e não apenas se são o mesmo objeto na memória.
 *
 * Exemplo de comportamento:
 * ```
 * val livro1 = Livro("Kotlin", "Roni", 2020)
 * val livro2 = Livro("Java", "Maria", 2010)
 * val resultado = livro1 == livro2  // retorna false
 * ```
 *
 * A comparação retorna `false` porque os dados dos dois objetos são diferentes.
 *
 * Se os dados fossem iguais:
 * ```
 * val livro3 = Livro("Kotlin", "Roni", 2020)
 * println(livro1 == livro3) // retorna true
 * ```
 */
data class Livro(
    val titulo: String,
    val autor: String,
    val ano: Int
)

// 🟡 Exercício 7: Enum
//Crie uma enum class chamada DiaSemana com os dias da semana,
//e uma função que imprime uma mensagem diferente dependendo do dia.

/**
 *  Exercício 7: Enum
 *
 * Este exercício demonstra o uso de `enum class` em Kotlin para representar os dias da semana.
 *
 * A `enum class DiaSemana` define constantes para cada dia da semana:
 * - Segunda, Terça, Quarta, Quinta, Sexta, Sabado, Domingo
 *
 * Também é criada uma função chamada `mensagemDia(dia: DiaSemana)`, que recebe um valor da enumeração
 * e imprime uma mensagem diferente dependendo do dia da semana.
 *
 * Isso mostra como usar `when` para executar diferentes blocos de código com base em valores de enum.
 *
 * Exemplo de uso:
 * ```
 * val dia = DiaSemana.Domingo
 * mensagemDia(dia) // Saída: "Prepare-se para a segunda."
 * ```
 *
 * Observação:
 * - O uso de letras acentuadas (como ç) em nomes de enums não é recomendado em código real por questões de compatibilidade.
 *   Uma alternativa seria usar "Terca" em vez de "Terça".
 */
enum class DiaSemana {
    Segunda,
    Terça,
    Quarta,
    Quinta,
    Sexta,
    Sabado,
    Domingo
}

fun menssagemDia(dia: DiaSemana) {
    when (dia) {
        DiaSemana.Segunda -> println("Começo de semana!")
        DiaSemana.Terça -> println("Ainda é terça...")
        DiaSemana.Quarta -> println("Meio da semana!")
        DiaSemana.Quinta -> println("Quase lá!")
        DiaSemana.Sexta -> println("Sextou!")
        DiaSemana.Sabado -> println("Dia de descanso!")
        DiaSemana.Domingo -> println("Prepare-se para a segunda.")
    }
}

// ✅ Nível 3 — Abstração, Interface, Objetos
//🟠 Exercício 8: Classe abstrata
//Crie uma classe abstrata FormaGeometrica com um metodo calcularArea().
// Crie duas classes: Quadrado e Circulo, que implementam o metodo.

/**
 *
 * Este exercício demonstra o uso de abstração em Kotlin.
 *
 * A classe abstrata `FormaGeometrica` define um método abstrato `calcularArea()`,
 * que deve ser implementado por todas as classes que herdarem dela.
 *
 * Classes concretas:
 * - `Quadrado`: recebe o lado como parâmetro e implementa o cálculo da área (lado × lado).
 * - `Circulo`: recebe o raio como parâmetro e implementa o cálculo da área (π × raio²).
 *
 * Exemplo de uso:
 * ```
 * val q = Quadrado(4.0)
 * val c = Circulo(3.0)
 * println(q.calcularArea())  // 16.0
 * println(c.calcularArea())  // 28.27...
 * ```
 *
 * Isso mostra como diferentes formas podem compartilhar uma interface comum (`calcularArea`)
 * mesmo que a lógica de cálculo seja diferente.
 */
// Classe abstrata com metodo abstrato
abstract class FormaGeometrica {
    abstract fun calcularArea(): Double
}

// Classe Quadrado que herda de FormaGeometrica
class Quadrado(val lado: Double) : FormaGeometrica() {
    override fun calcularArea(): Double {
        return lado * lado
    }
}

// Classe Circulo que herda de FormaGeometrica
class Circulo(val raio: Double) : FormaGeometrica() {
    override fun calcularArea(): Double {
        return Math.PI * raio * raio
    }
}

// 🟠 Exercício 9: Interface
//Crie uma interface chamada Imprimivel com um metodo imprimir().
//Crie classes Documento e Imagem que implementam essa interface.

/**
 *
 * Este exemplo demonstra o uso de uma interface chamada `Imprimivel`
 * que define um metodo abstrato `imprimir()`.
 *
 * As classes `Documento` e `Imagem` implementam a interface e fornecem
 * sua própria lógica para imprimir.
 *
 * Exemplo de uso:
 * ```
 * val doc = Documento("Contrato.pdf")
 * val img = Imagem("Foto.png")
 *
 * doc.imprimir()  // Saída: Imprimindo documento: Contrato.pdf
 * img.imprimir()  // Saída: Imprimindo imagem: Foto.png
 * ```
 *
 * Isso ilustra o conceito de polimorfismo com interfaces em Kotlin.
 */

// Interface com um metodo
interface Imprimivel {
    fun imprimir()
}

// Classe Documento que implementa Imprimivel
class Documento(val nome: String) : Imprimivel {
    override fun imprimir() {
        println("Imprimindo documento: $nome")
    }
}

// Classe Imagem que implementa Imprimivel
class Imagem(val arquivo: String) : Imprimivel {
    override fun imprimir() {
        println("Imprimindo imagem: $arquivo")
    }
}

// 🟠 Exercício 10: Singleton com object
//Crie um object chamado Config com uma variável
// idioma e uma função exibirConfiguracao().

/**
 *
 * Este exemplo utiliza o `object` Kotlin para criar um Singleton chamado `Config`.
 * Ele possui uma variável `idioma` e uma função `exibirConfiguracao()` que mostra o idioma atual.
 *
 * Exemplo de uso:
 * ```
 * Config.exibirConfiguracao()     // Exibe o idioma padrão
 * Config.idioma = "Inglês"        // Modifica o idioma
 * Config.exibirConfiguracao()     // Exibe o novo idioma
 * ```
 *
 * Como `object` é um Singleton, ele garante que `Config` terá apenas uma instância global no app.
 */

object Config {
    var idioma: String = "Portugues"

    fun exibirConfiguracao() {
        println("Idioma atual: $idioma")
    }
}

// 🟠 Exercício 11: companion object
// Crie uma classe Matematica com um
// companion object que tenha uma função somar(a, b).

/**
 *
 * A classe `Matematica` contém um `companion object` que fornece
 * uma função utilitária `somar(a, b)`, acessível diretamente pela classe.
 *
 * Exemplo de uso:
 * ```
 * val resultado = Matematica.somar(5, 3)
 * println(resultado) // 8
 * ```
 *
 * O uso de `companion object` permite acessar `somar` sem precisar instanciar `Matematica`.
 */
class Matematica() {
    companion object {
        fun somar(a: Int, b: Int): Int {
            return a + b
        }
    }
}

// ✅ Nível 4 — Avançado
// 🔴 Exercício 12: Classe genérica
// Crie uma classe genérica Caixa<T> que armazena um valor
// de qualquer tipo e imprime seu conteúdo.

/**
 *
 * A classe `Caixa<T>` é genérica e pode armazenar valores de qualquer tipo.
 * Ela possui um metodo `imprimir()` que exibe o conteúdo armazenado.
 *
 * Exemplo de uso:
 * ```
 * val caixaInt = Caixa(10)
 * val caixaTexto = Caixa("Texto")
 * caixaInt.imprimir()     // Conteúdo da caixa: 10
 * caixaTexto.imprimir()   // Conteúdo da caixa: Texto
 * ```
 *
 * A utilização de generics (`<T>`) permite reuso com tipos diferentes sem duplicar código.
 */
class Caixa<T>(private val valor: T) {
    fun imprimir() {
        println("Conteúdo da caixa: $valor")
    }
}

// 🔴 Exercício 13: Inner class
// Crie uma classe Computador com uma inner class chamada Processador,
// que acessa uma propriedade da classe externa.

/**
 *
 * A classe `Computador` representa um computador com uma marca.
 * A inner class `Processador` representa um processador associado a esse computador.
 * Por ser `inner`, a classe `Processador` pode acessar as propriedades da classe `Computador`.
 *
 * Exemplo de uso:
 * ```
 * val computador = Computador("Dell")
 * val processador = computador.Processador("Intel i7")
 * processador.exibirInfo()  // Saída: Computador da marca: Dell, com processador: Intel i7
 * ```
 */
class Computador(val marca: String) {

    inner class Processador(val modelo: String) {

        fun exibirInfo() {
            println("Computador da Marca: $marca, com processador: $modelo")
        }
    }
}

// 🔴 Exercício 14: Sobrecarga de métodos
// Crie uma classe Mensagem com dois métodos enviar():
// um que recebe uma String, e outro que recebe String + destinatario.

/**
 *
 * A classe `Mensagem` demonstra o conceito de sobrecarga, onde dois métodos com o mesmo nome
 * `enviar()` executam ações diferentes dependendo dos parâmetros.
 *
 * Métodos:
 * - `enviar(texto: String)` → Envia apenas o conteúdo da mensagem.
 * - `enviar(texto: String, destinatario: String)` → Envia o conteúdo da mensagem para um destinatário específico.
 *
 * Exemplo de uso:
 * ```
 * val msg = Mensagem()
 * msg.enviar("Olá!")                       // Saída: Enviando mensagem: "Olá!"
 * msg.enviar("Bom dia!", "João")          // Saída: Enviando mensagem para João: "Bom dia!"
 * ```
 */
class Mensagem {

    fun enviar(texto: String) {
        println("Enviando mensagem: \"$texto\"")
    }

    fun enviar(texto: String, destinatario: String) {
        println("Enviando mensagem para $destinatario: \"$texto\"")
    }
}

// 🔴 Exercício 15: Simulação de sistema
// Crie um mini sistema de cadastro de alunos com:
// Classe Aluno(nome, nota)
// Classe Turma, que contém uma lista de alunos e métodos para:
// Adicionar alunos
// Calcular média da turma
// Listar aprovados (nota >= 7)

/**
 *
 * Objetivo:
 * Criar um mini sistema de cadastro de alunos com:
 *
 * - Classe Aluno com nome e nota.
 * - Classe Turma que gerencia uma lista de alunos e oferece:
 *      - adicionarAluno(): adiciona um novo aluno à turma.
 *      - calcularMedia(): retorna a média das notas da turma.
 *      - listarAprovados(): retorna os alunos com nota maior ou igual a 7.
 *
 * Exemplo de uso:
 * ```
 * val turma = Turma()
 * turma.adicionarAluno(Aluno("Ana", 8.5))
 * turma.adicionarAluno(Aluno("Carlos", 6.0))
 * turma.calcularMedia() // retorna média da turma
 * turma.listarAprovados() // lista apenas os alunos com nota >= 7
 * ```
 */

data class Aluno(
    val nome: String,
    val nota: Double
)

class Turma() {
    private val alunos = mutableListOf<Aluno>()

    fun adicionarAluno(aluno: Aluno) {
        alunos.add(aluno)
    }

    // Calcula a média de notas da turma
    fun calcularMedia(): Double {
        if (alunos.isEmpty()) return 0.0
        return alunos.map { it.nota }.average()
    }

    // Retorna lista de alunos aprovados (nota >= 7.0)
    fun listarAprovados(): List<Aluno> {
        return alunos.filter { it.nota >= 7.0 }
    }
}

fun main() {

    }
