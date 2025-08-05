"use client";
import { CartaoPessoa } from "@/components/pessoas/cartao/cartao-pessoas";
import { Template } from "@/components/template/template"
import { BreadcrumbRoute } from "@/types/breadcrumb-routes";
import { useParams } from "next/navigation";

const CartaoPessoaPage = () => {

    const params = useParams();
    const queryId = params.id as string;

    const breadcrumb: BreadcrumbRoute[] = [
        {
            nome: "Pessoas",
            rota: "/pessoas"
        },
        {
            nome: "Cartão Pessoa",
            rota: "/pessoas/"
        }
    ]

    return (
        <Template route={breadcrumb}>
            <CartaoPessoa/>
        </Template>
    )
}

export default CartaoPessoaPage;