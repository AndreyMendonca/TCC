import { Template } from "@/components/template/template";
import { Button } from "@/components/ui/button";
import { BreadcrumbRoute } from "@/types/breadcrumb-routes";
import { PlusIcon } from "lucide-react";
import Link from "next/link";

const Page = () => {

    const breadcrumb: BreadcrumbRoute[] = [
        {
            nome: "Aluguéis",
            rota: "/alugueis"
        }
    ]

    return (
        <Template route={breadcrumb}>
            <Button variant="outline" asChild>
                <Link href="/alugueis/formulario/0">
                    <span className="flex items-center gap-2"><PlusIcon /> Cadastrar novo aluguel</span>
                </Link>
            </Button>
        </Template>
    )
}

export default Page;