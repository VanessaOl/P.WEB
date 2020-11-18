function calcularTudo(){
    this.soma();
    this.subtracao();
    this.produto();
    this.divisao();
    this.resto();
}

function soma() {   
    const nota1 = parseFloat(form.nota1.value);
    const nota2 = parseFloat(form.nota2.value);

    const soma = (nota1 + nota2);
    form.soma.value = soma;
}

function subtracao() {
    const nota1 =  parseFloat(form.nota1.value);
    const nota2 =  parseFloat(form.nota2.value);

    const subtracao = (nota1 - nota2);
    form.subtracao.value = subtracao;
}

function produto() {
    const nota1 = parseFloat(form.nota1.value);
    const nota2 = parseFloat(form.nota2.value);

    const produto = (nota1 * nota2);
    form.produto.value = produto;
}

function divisao() {
    const nota1 = parseFloat(form.nota1.value);
    const nota2 = parseFloat(form.nota2.value);

    const divisao = (nota1 / nota2);
    form.divisao.value = divisao;
}

function resto() {
    const nota1 = parseFloat(form.nota1.value);
    const nota2 = parseFloat(form.nota2.value);

    const resto = (nota1 % nota2);
    form.resto.value = resto;
}