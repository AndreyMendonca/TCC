import { Endereco } from "./endereco";

export type Pessoa = {
    id?: number;
    nome: string;
    sobrenome: string;
    cpf?: string;
    email?: string;
    dataNascimento?: Date;
    profissao?: string;
    ativa: boolean;
    tipoPessoaEnum: string;
    endereco?: Endereco; 
}