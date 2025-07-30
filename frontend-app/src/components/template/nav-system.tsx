"use client"

import * as React from "react"
import {
    SidebarMenu,
    SidebarMenuItem,
} from "@/components/ui/sidebar"

export function NavSystem({
    info,
}: {
    info: {
        name: string
        logo: React.ElementType
        info: string
    }
}) {
    return (
        <SidebarMenu>
            <SidebarMenuItem>
                <a href="/" className="flex gap-2 rounded-lg hover:bg-muted">
                    <div className="bg-sidebar-primary text-sidebar-primary-foreground flex aspect-square size-8 items-center justify-center rounded-lg">
                        <info.logo className="size-4" />
                    </div>
                    <div className="grid flex-1 text-left text-sm leading-tight">
                        <span className="truncate font-medium">{info.name}</span>
                        <span className="truncate text-xs">{info.info}</span>
                    </div>
                </a>
            </SidebarMenuItem>
        </SidebarMenu>
    )
}
