import { BreadcrumbRoute } from "@/types/breadcrumb-routes";
import { Breadcrumb, BreadcrumbItem, BreadcrumbLink, BreadcrumbList, BreadcrumbPage, BreadcrumbSeparator } from "../ui/breadcrumb";
import React from "react";

type Props = {
    breadcrumbs: BreadcrumbRoute[]
}

export const HeaderBreadCrumb = ({ breadcrumbs }: Props) => {
    return (
        <Breadcrumb>
            <BreadcrumbList>
                {breadcrumbs.map((crumb, idx) => (
                    <React.Fragment key={crumb.nome}>
                        <BreadcrumbItem className="hidden md:block">
                            {idx < breadcrumbs.length - 1 ? (
                                <BreadcrumbLink href={crumb.rota}>
                                    {crumb.nome}
                                </BreadcrumbLink>
                            ) : (
                                <BreadcrumbPage>
                                    {crumb.nome}
                                </BreadcrumbPage>
                            )}
                        </BreadcrumbItem>
                        {idx < breadcrumbs.length - 1 && (
                            <BreadcrumbSeparator className="hidden md:block" />
                        )}
                    </React.Fragment>
                ))}
            </BreadcrumbList>
        </Breadcrumb>
    );
}


{/*
    <BreadcrumbItem className="hidden md:block">
        <BreadcrumbLink href="#">
            Building Your Application
        </BreadcrumbLink>
    </BreadcrumbItem>
    
    <BreadcrumbItem>
        <BreadcrumbPage>Data Fetching</BreadcrumbPage>
    </BreadcrumbItem>
*/}