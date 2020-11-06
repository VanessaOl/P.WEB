function encontraMaior() {
    const input1 = form.input1.valueAsNumber;
    const input2 = form.input2.valueAsNumber;
    const input3 = form.input3.valueAsNumber;

    const maior_1e2 = maior(input1, input2);
    const maior_1e2_e3 = maior(maior_1e2, input3);

    form.saida.value = maior_1e2_e3;
}

function maior(numero1, numero2) {
    const resultado = (numero1 + numero2 + Math.abs(numero1 - numero2)) / 2;
    return resultado;
}

//só uma função
function simplificada_encontraMaior() {
    const input1 = form.input1.valueAsNumber;
    const input2 = form.input2.valueAsNumber;
    const input3 = form.input3.valueAsNumber;

    const maior_1e2 = (input1 + input2 + Math.abs(input1 - input2)) / 2;
    const maior_1e2_e3 = (maior_1e2 + input3 + Math.abs(maior_1e2 - input3)) / 2;

    form.saida.value = maior_1e2_e3;
} /////

// opcional
function otimizada_encontrarMaior() {
    const { input1, input2, input3 } = form;
    
    const maior_1e2 = maior(input1.valueAsNumber, input2.valueAsNumber);
    const maior_1e2_e3 = maior(maior_1e2, input3.valueAsNumber);

    form.saida.value = maior_1e2_e3;
}
///////