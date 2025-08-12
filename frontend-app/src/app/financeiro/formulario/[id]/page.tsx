"use client";
import { Template } from "@/components/template/template";
import { Button } from "@/components/ui/button";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { BreadcrumbRoute } from "@/types/breadcrumb-routes";
import { CalendarIcon, PlusIcon } from "lucide-react";
import Link from "next/link";
import { useForm } from "react-hook-form";
import { z } from "zod";
import { useParams } from "next/navigation";
import { Form, FormControl, FormDescription, FormField, FormItem, FormLabel, FormMessage } from "@/components/ui/form";
import { zodResolver } from "@hookform/resolvers/zod";
import { Input } from "@/components/ui/input";
import { Popover, PopoverContent, PopoverTrigger } from "@/components/ui/popover";
import { useState } from "react";
import { Calendar } from "@/components/ui/calendar";
import { cn } from "@/lib/utils";
import { Select, SelectContent, SelectGroup, SelectItem, SelectLabel, SelectTrigger, SelectValue } from "@/components/ui/select";


const formSchema = z.object({
    identificacao: z.string().optional(),
    descricao: z.string().optional(),
    tipoLancamento: z.string().optional(),
    valorTotal: z.string().optional(),
    numeroParcelas: z.string().optional(),
    dataLancamento: z.date().optional(),
    dataVencimento: z.date().optional(),
    dataExecutado: z.date().optional(),
    statusLacamento: z.string().optional(),
    realizadoPorQuem: z.string().optional(),
})


const Page = () => {
    const params = useParams();
    const queryId = params.id as string;
    const [modalCalendario, setModalCalendario] = useState(false)
    const [modalCalendarioVencimento, setModalCalendarioVencimento] = useState(false)
    const [modalCalendarioExecucao, setModalCalendarioExecucao] = useState(false)

    const form = useForm<z.infer<typeof formSchema>>({
        resolver: zodResolver(formSchema),
        defaultValues: {
            dataLancamento: new Date()
        }
    })

    const onSubmit = async (values: z.infer<typeof formSchema>) => {
        console.log(values);
    }


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
                    <Form {...form}>
                        <form onSubmit={form.handleSubmit(onSubmit)} className="grid grid-cols-1 md:grid-cols-2 gap-2" noValidate>
                            <div className="md:col-span-2 border-2 rounded-md flex-1 pb-4 space-y-2">
                                <div className="bg-muted/50 p-2 font-semibold">
                                    <p>Dados do Lançamento</p>
                                </div>
                                <div className="flex gap-10 px-4">
                                    <FormField
                                        control={form.control}
                                        name="tipoLancamento"
                                        render={({ field }) => (
                                            <FormItem>
                                                <FormLabel>Tipo de Lançamento *</FormLabel>
                                                <FormDescription>Selecione o tipo de lançamento</FormDescription>
                                                <FormControl>
                                                    <Select onValueChange={field.onChange} defaultValue={field.value}>
                                                        <SelectTrigger className="w-full">
                                                            <SelectValue placeholder="Selecione" />
                                                        </SelectTrigger>
                                                        <SelectContent >
                                                            <SelectGroup>
                                                                <SelectLabel>Tipo</SelectLabel>
                                                                <SelectItem value="RECEITA">Receita</SelectItem>
                                                                <SelectItem value="DESPESA">Despesa</SelectItem>
                                                            </SelectGroup>
                                                        </SelectContent>
                                                    </Select>
                                                </FormControl>
                                                <FormMessage />
                                            </FormItem>
                                        )}
                                    />
                                    <FormField
                                        control={form.control}
                                        name="dataLancamento"
                                        render={({ field }) => (
                                            <FormItem>
                                                <FormLabel>Data de Lançamento</FormLabel>
                                                <FormDescription>Data de lançamento será sempre o dia atual</FormDescription>
                                                <Popover open={modalCalendario} onOpenChange={setModalCalendario}>
                                                    <PopoverTrigger asChild>
                                                        <FormControl>
                                                            <Button
                                                                disabled={true}
                                                                variant={"outline"}
                                                                className={cn(
                                                                    "pl-3 text-left font-normal",
                                                                    !field.value && "text-muted-foreground"
                                                                )}
                                                            >
                                                                {field.value ? (
                                                                    field.value.toLocaleDateString()
                                                                ) : (
                                                                    <span>Selecione a data</span>
                                                                )}
                                                                <CalendarIcon className="ml-auto h-4 w-4 opacity-50" />
                                                            </Button>
                                                        </FormControl>
                                                    </PopoverTrigger>
                                                    <PopoverContent className="w-auto p-0" align="start">
                                                        <Calendar
                                                            mode="single"
                                                            selected={field.value}
                                                            onSelect={(date) => {
                                                                field.onChange(date);
                                                            }}
                                                            captionLayout="dropdown"
                                                        />
                                                    </PopoverContent>
                                                </Popover>
                                                <FormMessage />
                                            </FormItem>
                                        )}
                                    />
                                </div>
                                <div className="flex gap-3 px-4">
                                    <FormField
                                        control={form.control}
                                        name="identificacao"
                                        render={({ field }) => (
                                            <FormItem className="flex-1">
                                                <FormLabel>Identificação *</FormLabel>
                                                <FormControl>
                                                    <Input
                                                        placeholder="Digite a identificação"
                                                        {...field}
                                                    />
                                                </FormControl>
                                                <FormMessage />
                                            </FormItem>
                                        )}
                                    />
                                    <FormField
                                        control={form.control}
                                        name="descricao"
                                        render={({ field }) => (
                                            <FormItem className="flex-1">
                                                <FormLabel>Descricao *</FormLabel>
                                                <FormControl>
                                                    <Input
                                                        placeholder="Digite o descrição"
                                                        {...field}
                                                    />
                                                </FormControl>
                                                <FormMessage />
                                            </FormItem>
                                        )}
                                    />
                                    <FormField
                                        control={form.control}
                                        name="dataVencimento"
                                        render={({ field }) => (
                                            <FormItem className="flex-1">
                                                <FormLabel>Data de Vencimento</FormLabel>
                                                <Popover open={modalCalendarioVencimento} onOpenChange={setModalCalendarioVencimento}>
                                                    <PopoverTrigger asChild>
                                                        <FormControl>
                                                            <Button
                                                                variant={"outline"}
                                                                className={cn(
                                                                    "pl-3 text-left font-normal",
                                                                    !field.value && "text-muted-foreground"
                                                                )}
                                                            >
                                                                {field.value ? (
                                                                    field.value.toLocaleDateString()
                                                                ) : (
                                                                    <span>Selecione a data</span>
                                                                )}
                                                                <CalendarIcon className="ml-auto h-4 w-4 opacity-50" />
                                                            </Button>
                                                        </FormControl>
                                                    </PopoverTrigger>
                                                    <PopoverContent className="w-auto p-0" align="start">
                                                        <Calendar
                                                            mode="single"
                                                            selected={field.value}
                                                            onSelect={(date) => {
                                                                field.onChange(date);
                                                                setModalCalendario(false);
                                                            }}
                                                            disabled={(date) =>
                                                                date <= new Date()
                                                            }
                                                            captionLayout="dropdown"
                                                        />
                                                    </PopoverContent>
                                                </Popover>
                                                <FormMessage />
                                            </FormItem>
                                        )}
                                    />
                                </div>
                                <div className="flex gap-3 px-4">
                                    <FormField
                                        control={form.control}
                                        name="dataExecutado"
                                        render={({ field }) => (
                                            <FormItem className="flex-1">
                                                <FormLabel>Data de Execução</FormLabel>
                                                <Popover open={modalCalendario} onOpenChange={setModalCalendario}>
                                                    <PopoverTrigger asChild>
                                                        <FormControl>
                                                            <Button
                                                                disabled={true}
                                                                variant={"outline"}
                                                                className={cn(
                                                                    "pl-3 text-left font-normal",
                                                                    !field.value && "text-muted-foreground"
                                                                )}
                                                            >
                                                                {field.value ? (
                                                                    field.value.toLocaleDateString()
                                                                ) : (
                                                                    <span>Selecione a data</span>
                                                                )}
                                                                <CalendarIcon className="ml-auto h-4 w-4 opacity-50" />
                                                            </Button>
                                                        </FormControl>
                                                    </PopoverTrigger>
                                                    <PopoverContent className="w-auto p-0" align="start">
                                                        <Calendar
                                                            mode="single"
                                                            selected={field.value}
                                                            onSelect={(date) => {
                                                                field.onChange(date);
                                                                setModalCalendario(false);
                                                            }}
                                                            disabled={(date) =>
                                                                date > new Date() || date < new Date("1900-01-01")
                                                            }
                                                            captionLayout="dropdown"
                                                        />
                                                    </PopoverContent>
                                                </Popover>
                                                <FormMessage />
                                            </FormItem>
                                        )}
                                    />
                                </div>
                            </div>
                        </form>
                    </Form>
                </CardContent>
            </Card>
        </Template>
    )

}

export default Page;