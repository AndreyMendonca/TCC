"use client"

import * as React from "react"
import {
    ChartArea,
    House,
    HousePlug,
    MapPinHouse,
    UsersRound,
    WalletMinimal,
} from "lucide-react"

import {
    Sidebar,
    SidebarContent,
    SidebarFooter,
    SidebarHeader,
    SidebarRail,
} from "@/components/ui/sidebar"
import { NavSystem } from "./nav-system"
import { NavMain } from "./nav-main"
import { NavUser } from "./nav-user"

const data = {
    user: {
        name: "Exemplo",
        email: "exe@examplo.com",
        avatar: "/avatar.svg",
    },
    system: {
        name: "RentMaster",
        logo: HousePlug,
        info: "www.rentmaster.com.br",
    },
    navMain: [
        {
            title: "Dashboard",
            url: "/",
            icon: ChartArea
        },
        {
            title: "Imóveis",
            url: "/imoveis",
            icon: House
        },
        {
            title: "Aluguéis",
            url: "/alugueis",
            icon: MapPinHouse
        },
        {
            title: "Financeiro",
            url: "financeiro",
            icon: WalletMinimal,
        },
        {
            title: "Pessoas",
            url: "/pessoas",
            icon: UsersRound
        },
    ]
}

export function AppSidebar({ ...props }: React.ComponentProps<typeof Sidebar>) {
    return (
        <Sidebar collapsible="icon" {...props}>
            <SidebarHeader>
                <NavSystem info={data.system} />
            </SidebarHeader>
            <SidebarContent>
                <NavMain items={data.navMain} />
            </SidebarContent>
            <SidebarFooter>
                <NavUser user={data.user} />
            </SidebarFooter>
            <SidebarRail />
        </Sidebar>
    )
}
