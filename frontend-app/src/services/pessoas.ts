import { Pessoa } from "@/types/pessoas";
import { api } from "./axios";
import { AxiosResponse } from "axios";

const URL: string = '/pessoas';
export const PessoasService = {

    salvar: async (pessoa: Pessoa): Promise<Pessoa> => {
        const formData = new FormData();

        formData.append('nome', pessoa.nome);
        formData.append('sobrenome', pessoa.sobrenome);
        formData.append('ativa', String(pessoa.ativa));
        formData.append('tipoPessoa', pessoa.tipoPessoa);

        console.log('FormData:', formData);

        const response: AxiosResponse<Pessoa> = await api.post(`${URL}/todosDados`, formData);

        return response.data;
    }
}

