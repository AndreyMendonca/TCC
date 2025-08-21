"use client";
import { Template } from "@/components/template/template"
import { BreadcrumbRoute } from "@/types/breadcrumb-routes";
import { useParams } from "next/navigation";
import { useForm } from "react-hook-form";
import { z } from "zod";
import { zodResolver } from '@hookform/resolvers/zod'
import { Form, FormControl, FormDescription, FormField, FormItem, FormLabel, FormMessage } from "@/components/ui/form";
import { Input } from "@/components/ui/input";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Popover, PopoverContent, PopoverTrigger } from "@/components/ui/popover";
import { Button } from "@/components/ui/button";
import { cn } from "@/lib/utils";
import { CalendarIcon, MoveLeft } from "lucide-react";
import { useState } from "react";
import { Calendar } from "@/components/ui/calendar";
import { Select, SelectContent, SelectGroup, SelectItem, SelectLabel, SelectTrigger, SelectValue } from "@/components/ui/select";
import { Switch } from "@/components/ui/switch";
import InputFotoPerfil from "@/components/input-foto-perfil";
import InputUploadArquivos from "@/components/input-upload-arquivos";
import { PessoasService } from "@/services/pessoas";
import { toast } from "sonner";
import { FormGrupo } from "@/components/form-grupo";


export const enderecoSchema = z.object({
    cep: z.string().optional(),
    logradouro: z.string().optional(),
    numero: z.string().optional(),
    bairro: z.string().optional(),
    localidade: z.string().optional(),
    uf: z.string().optional(),
    pais: z.string().optional(),
});


export const formSchema = z.object({
    nome: z.string().min(2, { message: "O nome é obrigatório." }),
    sobrenome: z.string().min(2, { message: "O sobrenome é obrigatório." }),
    cpf: z.string().optional(),
    email: z.string().optional(),
    dataNascimento: z.date().optional(),
    profissao: z.string().optional(),
    ativa: z.boolean(),
    tipoPessoaEnum: z.string().min(1, { message: "O tipo de pessoa é obrigatório" }),
    endereco: enderecoSchema.optional(),
});

const formularioPessoasPage = () => {
    const service = PessoasService;
    const params = useParams();
    const queryId = params.id as string;
    const [modalCalendario, setModalCalendario] = useState(false)

    const form = useForm<z.infer<typeof formSchema>>({
        resolver: zodResolver(formSchema),
        defaultValues: {
            nome: '',
            sobrenome: '',
            ativa: true,
            tipoPessoaEnum: '',
        }
    })

    const onSubmit = async (values: z.infer<typeof formSchema>) => {
        alert("Estoua aqui")
        await service.salvar(values)
            .then(() => toast.success("Sucesso", { description: "Sucesso ao cadastrar pessoa" }))
            .catch(() => toast.error("Erro", { description: "Erro ao cadastrar pessoa" }));

        console.log(values);
    }


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
            <Card className="gap-2">
                <CardHeader>
                    <CardTitle className="mb-1 flex items-center gap-2">
                        Cadastrar nova pessoa
                    </CardTitle>
                </CardHeader>
                <CardContent>
                    <Form {...form}>
                        <form onSubmit={form.handleSubmit(onSubmit)} className="flex flex-col gap-4" noValidate>
                            <FormGrupo titulo="Informações da Pessoa">
                                <FormField
                                    control={form.control}
                                    name="nome"
                                    render={({ field }) => (
                                        <FormItem className="flex-1">
                                            <FormLabel>Nome *</FormLabel>
                                            <FormControl>
                                                <Input
                                                    placeholder="Digite o nome"
                                                    {...field}
                                                />
                                            </FormControl>
                                            <FormMessage />
                                        </FormItem>
                                    )}
                                />
                                <FormField
                                    control={form.control}
                                    name="sobrenome"
                                    render={({ field }) => (
                                        <FormItem className="flex-1">
                                            <FormLabel>Sobrenome *</FormLabel>
                                            <FormControl>
                                                <Input
                                                    placeholder="Digite o sobrenome"
                                                    {...field}
                                                />
                                            </FormControl>
                                            <FormMessage />
                                        </FormItem>
                                    )}
                                />
                                <FormField
                                    control={form.control}
                                    name="cpf"
                                    render={({ field }) => (
                                        <FormItem className="flex-1">
                                            <FormLabel>CPF *</FormLabel>
                                            <FormControl>
                                                <Input
                                                    placeholder="Digite o CPF"
                                                    {...field}
                                                />
                                            </FormControl>
                                            <FormMessage />
                                        </FormItem>
                                    )}
                                />
                                <FormField
                                    control={form.control}
                                    name="dataNascimento"
                                    render={({ field }) => (
                                        <FormItem className="flex-1">
                                            <FormLabel>Data de nascimento</FormLabel>
                                            <Popover open={modalCalendario} onOpenChange={setModalCalendario}>
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
                                <FormField
                                    control={form.control}
                                    name="email"
                                    render={({ field }) => (
                                        <FormItem className="flex-1">
                                            <FormLabel>Email *</FormLabel>
                                            <FormControl>
                                                <Input
                                                    placeholder="Digite o email"
                                                    {...field}
                                                />
                                            </FormControl>
                                            <FormMessage />
                                        </FormItem>
                                    )}
                                />
                            </FormGrupo>
                            <FormGrupo titulo="Endereço">
                                <FormField
                                    control={form.control}
                                    name="endereco.cep"
                                    render={({ field }) => (
                                        <FormItem className="flex-1">
                                            <FormLabel>CEP *</FormLabel>
                                            <FormControl>
                                                <Input
                                                    placeholder="Digite o CEP"
                                                    {...field}
                                                />
                                            </FormControl>
                                            <FormMessage />
                                        </FormItem>
                                    )}
                                />
                                <FormField
                                    control={form.control}
                                    name="endereco.numero"
                                    render={({ field }) => (
                                        <FormItem className="flex-1">
                                            <FormLabel>Numero *</FormLabel>
                                            <FormControl>
                                                <Input
                                                    placeholder="Digite o número"
                                                    {...field}
                                                />
                                            </FormControl>
                                            <FormMessage />
                                        </FormItem>
                                    )}
                                />
                                <FormField
                                    control={form.control}
                                    name="endereco.logradouro"
                                    render={({ field }) => (
                                        <FormItem className="flex-1">
                                            <FormLabel>Endereço *</FormLabel>
                                            <FormControl>
                                                <Input
                                                    placeholder="Digite o endereço"
                                                    {...field}
                                                />
                                            </FormControl>
                                            <FormMessage />
                                        </FormItem>
                                    )}
                                />
                                <FormField
                                    control={form.control}
                                    name="endereco.localidade"
                                    render={({ field }) => (
                                        <FormItem className="flex-1">
                                            <FormLabel>Cidade *</FormLabel>
                                            <FormControl>
                                                <Input
                                                    placeholder="Digite a cidade"
                                                    {...field}
                                                />
                                            </FormControl>
                                            <FormMessage />
                                        </FormItem>
                                    )}
                                />
                                <FormField
                                    control={form.control}
                                    name="endereco.uf"
                                    render={({ field }) => (
                                        <FormItem className="flex-1">
                                            <FormLabel>UF *</FormLabel>
                                            <FormControl>
                                                <Input
                                                    placeholder="Digite a UF"
                                                    {...field}
                                                />
                                            </FormControl>
                                            <FormMessage />
                                        </FormItem>
                                    )}
                                />
                            </FormGrupo>
                            <FormGrupo titulo="Dados Adicionais">
                                <InputFotoPerfil />
                                <FormField
                                    control={form.control}
                                    name="profissao"
                                    render={({ field }) => (
                                        <FormItem className="flex-1">
                                            <FormLabel>Profissão *</FormLabel>
                                            <FormControl>
                                                <Input
                                                    placeholder="Digite o profissão"
                                                    {...field}
                                                />
                                            </FormControl>
                                            <FormMessage />
                                        </FormItem>
                                    )}
                                />
                                <FormField
                                    control={form.control}
                                    name="tipoPessoaEnum"
                                    render={({ field }) => (
                                        <FormItem >
                                            <FormLabel>Tipo de pessoa *</FormLabel>

                                            <Select onValueChange={field.onChange} defaultValue={field.value}>
                                                <FormControl>
                                                    <SelectTrigger className="w-full">
                                                        <SelectValue placeholder="Selecione o tipo de pessoa" />
                                                    </SelectTrigger>
                                                </FormControl>
                                                <SelectContent >
                                                    <SelectGroup>
                                                        <SelectLabel>Tipo</SelectLabel>
                                                        <SelectItem value="inquilino">Inquilino</SelectItem>
                                                        <SelectItem value="fiador">Fiador</SelectItem>
                                                    </SelectGroup>
                                                </SelectContent>
                                            </Select>
                                            <FormMessage />
                                        </FormItem>
                                    )}
                                />
                                <FormField
                                    control={form.control}
                                    name="ativa"
                                    render={({ field }) => (
                                        <FormItem >
                                            <FormLabel>Status</FormLabel>
                                            <div className="flex gap-4">
                                                <FormControl>
                                                    <Switch
                                                        checked={field.value}
                                                        onCheckedChange={field.onChange}
                                                    />
                                                </FormControl>
                                                <FormDescription>{field.value ? "Ativo" : "Inativo"}</FormDescription>
                                            </div>
                                            <FormMessage />
                                        </FormItem>
                                    )}
                                />
                            </FormGrupo>
                            <FormGrupo titulo="Documentos">
                                <InputUploadArquivos />
                            </FormGrupo>

                            <div>
                                <Button type="submit" className="min-w-40">Cadastrar</Button>
                            </div>
                        </form>
                    </Form>
                </CardContent>
            </Card>
        </Template>
    )
}

export default formularioPessoasPage;