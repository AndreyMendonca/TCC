"use client";
import { Template } from "@/components/template/template";
import { Button } from "@/components/ui/button";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { BreadcrumbRoute } from "@/types/breadcrumb-routes";
import { PlusIcon } from "lucide-react";
import Link from "next/link";
import { useParams } from "next/navigation";

const Page = () => {
    const params = useParams();
    const queryId = params.id as string;

    const breadcrumb: BreadcrumbRoute[] = [
        {
            nome: "Financeiro",
            rota: "/financeiro"
        },
        {
            nome: `${queryId === "0" ? "Cadastrar novo Lançamento" : "Editar Lançamento"}`,
            rota: "/financeiro/"
        }
    ]

    return (
        <Template route={breadcrumb}>
            <Card>
                <CardHeader>
                    <CardTitle>
                        {queryId === "0" ? "Cadastrar novo Lançamento" : "Editar Lançamento"}
                    </CardTitle>
                </CardHeader>
                <CardContent>
                    <p>Formulario</p>
                </CardContent>
            </Card>
        </Template>
    )
}

export default Page;