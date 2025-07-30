import { BreadcrumbRoute } from "@/types/breadcrumb-routes"
import { Breadcrumb, BreadcrumbItem, BreadcrumbLink, BreadcrumbList, BreadcrumbPage, BreadcrumbSeparator } from "../ui/breadcrumb"
import { Separator } from "../ui/separator"
import { SidebarInset, SidebarProvider, SidebarTrigger } from "../ui/sidebar"
import { AppSidebar } from "./app-sidebar"
import { HeaderBreadCrumb } from "./header-breadcrumb"

type Props = {
    children: React.ReactNode
    route: BreadcrumbRoute[]
}

export const Template = ({children, route }:Props) =>{
    return (
        <SidebarProvider>
            <AppSidebar />
            <SidebarInset className="flex h-svh flex-col">
                <header className="sticky top-0 z-10 flex bg-background h-16 shrink-0 items-center gap-2 transition-[width,height] ease-linear group-has-data-[collapsible=icon]/sidebar-wrapper:h-12">
                    <div className="flex items-center gap-2 px-4">
                        <SidebarTrigger className="-ml-1" />
                        <Separator
                            orientation="vertical"
                            className="mr-2 data-[orientation=vertical]:h-4"
                        />
                        <HeaderBreadCrumb breadcrumbs={route} />
                    </div>
                </header>
                <div className="flex flex-1 flex-col overflow-y-auto gap-4 px-4">
                    {children}
                </div>
            </SidebarInset>
        </SidebarProvider>
    )
}