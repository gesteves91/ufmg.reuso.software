package br.ufmg.reuso.negocio.jogo;

public class Context {
    private StrategyLevel strategy;

    public Context(StrategyLevel strategy){
        this.strategy = strategy;
    }

    public String executeStrategy(){
        return strategy.setLevel();
    }
}