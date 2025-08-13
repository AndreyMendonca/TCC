import { Pessoa } from "@/types/pessoas";
import { api } from "./axios";
import { AxiosResponse } from "axios";

const URL: string = '/pessoas';
export const PessoasService = {

    salvar: async (pessoa: Pessoa): Promise<Pessoa> => {
        const formData = new FormData();

        formData.append('nome', pessoa.nome);
        formData.append('sobrenome', pessoa.sobrenome);
        formData.append('cpf', pessoa.cpf ?? '');
        formData.append('email', pessoa.email ?? '');
        formData.append('profissao', pessoa.profissao ?? '');
        formData.append('ativa', String(pessoa.ativa));
        formData.append('tipoPessoaEnum', pessoa.tipoPessoaEnum);
        if (pessoa.dataNascimento) {
            formData.append('dataNascimento', pessoa.dataNascimento.toISOString());
        }
        if (pessoa.endereco) {
            formData.append('endereco.cep', pessoa.endereco.cep ?? '');
            formData.append('endereco.numero', pessoa.endereco.numero ?? '');
            formData.append('endereco.bairro', pessoa.endereco.bairro ?? 'oi');
            formData.append('endereco.localidade', pessoa.endereco.localidade ?? '');
            formData.append('endereco.uf', pessoa.endereco.uf ?? 'oi');
            formData.append('endereco.pais', pessoa.endereco.pais ?? 'oi');
        }


        const response: AxiosResponse<Pessoa> = await api.post(`${URL}/todosDados`, formData, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        });

        return response.data;
    }
}

