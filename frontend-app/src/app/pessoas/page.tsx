import { Template } from "@/components/template/template"
import { Button } from "@/components/ui/button"
import { BreadcrumbRoute } from "@/types/breadcrumb-routes"
import { PlusIcon } from "lucide-react"
import Link from "next/link"

const PessoasPage = () => {
    const breadcrumb: BreadcrumbRoute[] = [
        {
            nome: "Pessoas",
            rota: "/pessoas"
        }
    ]
    return  (
        <Template route={breadcrumb}>
            <Button variant="outline" asChild>
                <Link href="/pessoas/formulario/0">
                    <span className="flex items-center gap-2"><PlusIcon/> Cadastrar nova pessoa</span>                
                </Link>
            </Button>
        </Template>
    )
}

export default PessoasPage;