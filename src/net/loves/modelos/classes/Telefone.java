/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.loves.modelos.classes;

/**
 *
 * @author Thiago
 */
public class Telefone {
    private int ddi = 0; 
    private int ddd = 0;
    private int numero = 0;
    // Construtor sem parâmetros
    public Telefone() {
        ddi = 0; // valor default do Brasil
        ddd = 0;
        numero = 0;
    }
 
    // Construtor com parâmetros
    public Telefone(int ddi, int ddd, int numero) throws Exception {
        // Verificando a validade dos parâmetros
        if (!validarDdi(ddi)) {
            throw new Exception("DDI inválido.");
        }
        if (!validarDdd(ddd)) {
            throw new Exception("DDD inválido.");
        }
        if (!validarNumero(numero)) {
            throw new Exception("Número de telefone inválido.");
        }
 
        this.ddi = ddi;
        this.ddd = ddd;
        this.numero = numero;
    }
 
    // Método estático para criar Telefone a partir de uma string
    public static Telefone fromString(String telefoneStr) throws Exception {
        // Remover todos os caracteres não numéricos
        telefoneStr = telefoneStr.replaceAll("[^0-9]", "");
 
        // Se o telefone tem mais de 11 dígitos, consideramos que é DDI + DDD + número
        if (telefoneStr.length() < 10 || telefoneStr.length() > 13) {
            throw new Exception("Número de telefone inválido. Deve ter entre 10 e 13 dígitos (com DDI opcional).");
        }
 
        int ddi = 0;  
        int ddd;
        int numero;
 
        if (telefoneStr.length() == 13) {
            // Caso o telefone tenha 13 dígitos (com DDI + DDD + número)
            ddi = Integer.parseInt(telefoneStr.substring(0, 2)); // Os dois primeiros dígitos são o DDI
            ddd = Integer.parseInt(telefoneStr.substring(2, 4)); // Os próximos dois dígitos são o DDD
            numero = Integer.parseInt(telefoneStr.substring(4));  // O restante é o número
        } else if (telefoneStr.length() == 11) {
            // Caso o telefone tenha 11 dígitos (sem DDI, apenas DDD + número)
            ddd = Integer.parseInt(telefoneStr.substring(0, 2)); // DDD
            numero = Integer.parseInt(telefoneStr.substring(2));  // Número
        } else {
            // Caso o telefone tenha 10 dígitos (sem DDI, apenas DDD + número)
            ddd = Integer.parseInt(telefoneStr.substring(0, 2)); // DDD
            numero = Integer.parseInt(telefoneStr.substring(2));  // Número
        }
 
        // Validar o DDD e o número
        if (!validarDdd(ddd)) {
            throw new Exception("DDD inválido.");
        }
        if (!validarNumero(numero)) {
            throw new Exception("Número de telefone inválido.");
        }
 
        return new Telefone(ddi, ddd, numero);
    }
 
    // Validação do DDI
    private static boolean validarDdi(int ddi) {
        // A lógica de validação do DDI pode ser aprimorada conforme necessário
        return ddi > 0 && ddi < 1000; // Apenas um exemplo de faixa de DDI
    }
 
    // Validação do DDD
    private static boolean validarDdd(int ddd) {
        return ddd >= 11 && ddd <= 99; // Considera DDDs válidos entre 11 e 99
    }
 
    // Validação do número
    private static boolean validarNumero(int numero) {
        // A validação de número agora é feita considerando que o número tem 8 ou 9 dígitos
        return String.valueOf(numero).length() == 8 || String.valueOf(numero).length() == 9;
    }
 
    // Getters e Setters
    public int getDdi() {
        return ddi;
    }
 
    public void setDdi(int ddi) throws Exception {
        if (!validarDdi(ddi)) {
            throw new Exception("DDI inválido.");
        }
        this.ddi = ddi;
    }
 
    public int getDdd() {
        return ddd;
    }
 
    public void setDdd(int ddd) throws Exception {
        if (!validarDdd(ddd)) {
            throw new Exception("DDD inválido.");
        }
        this.ddd = ddd;
    }
 
    public int getNumero() {
        return numero;
    }
 
    public void setNumero(int numero) throws Exception {
        if (!validarNumero(numero)) {
            throw new Exception("Número de telefone inválido.");
        }
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "+" + ddi + " (" + ddd + ") " + numero;
    }

  
    
}