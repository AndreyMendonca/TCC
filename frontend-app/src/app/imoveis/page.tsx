import { Template } from "@/components/template/template";
import { BreadcrumbRoute } from "@/types/breadcrumb-routes";

const Page = () => {

    const breadcrumb: BreadcrumbRoute[] = [
        {
            nome: "Imóveis",
            rota: "/imoveis"
        }
    ]

    return (
        <Template route={breadcrumb}>
            <div className="grid auto-rows-min gap-4 md:grid-cols-3">
                <div className="bg-amber-100 aspect-video rounded-xl" />
                <div className="bg-muted/50 aspect-video rounded-xl" />
                <div className="bg-amber-100 aspect-video rounded-xl" />
            </div>
            <div className="bg-muted/50 min-h-[100vh] flex-1 rounded-xl md:min-h-min" />
            <div className="grid auto-rows-min gap-4 md:grid-cols-3">
                <div className="bg-muted/50 aspect-video rounded-xl" />
                <div className="bg-amber-100 aspect-video rounded-xl" />
                <div className="bg-muted/50 aspect-video rounded-xl" />
            </div>
            <div className="grid auto-rows-min gap-4 md:grid-cols-3">
                <div className="bg-amber-100 aspect-video rounded-xl" />
                <div className="bg-muted/50 aspect-video rounded-xl" />
                <div className="bg-amber-100 aspect-video rounded-xl" />
            </div>
            <div className="grid auto-rows-min gap-4 md:grid-cols-3">
                <div className="bg-muted/50 aspect-video rounded-xl" />
                <div className="bg-amber-100 aspect-video rounded-xl" />
                <div className="bg-muted/50 aspect-video rounded-xl" />
            </div>
        </Template>
    )
}

export default Page;