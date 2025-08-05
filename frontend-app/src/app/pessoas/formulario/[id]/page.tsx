"use client";
import { Template } from "@/components/template/template"
import { BreadcrumbRoute } from "@/types/breadcrumb-routes";
import { useParams } from "next/navigation";

const formularioPessoasPage = () => {
    const params = useParams();
    const queryId = params.id as string;

    const breadcrumb: BreadcrumbRoute[] = [
        {
            nome: "Pessoas",
            rota: "/pessoas"
        },
        {
            nome: `${queryId === "0" ? "Cadastrar nova pessoa" : "Editar pessoa"}`,
            rota: "/pessoas/"
        }
    ]

    return (
        <Template route={breadcrumb}>
            <p>formulario</p>
        </Template>
    )
}

export default formularioPessoasPage;