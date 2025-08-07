import { Alert, AlertDescription, AlertTitle } from "@/components/ui/alert";
import { Button } from "@/components/ui/button";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs";
import { BanknoteArrowDown, BanknoteArrowUp, BanknoteX, CheckCircle2Icon, Download, Eye, File, FileImage, FileText, MapPin, Trash } from "lucide-react";

export const ComplementoDados = () => {
    return (
        <div className="rounded-md w-full">
            <Tabs defaultValue="aluguel">
                <TabsList className="bg-muted/50">
                    <TabsTrigger value="aluguel">Aluguel</TabsTrigger>
                    <TabsTrigger value="financas">Finanças</TabsTrigger>
                    <TabsTrigger value="arquivos">Arquivos</TabsTrigger>
                </TabsList>
                <TabsContent value="aluguel">
                    <Card className="w-full">
                        <CardContent className="space-y-4">
                            <div className="flex flex-col border p-2 rounded-md bg-muted/50">
                                <div className="flex items-center justify-between">
                                    <div>
                                        <p className="font-medium">Descricao do Contrato</p>
                                        <span className="flex items-center gap-2 text-sm"> <MapPin size={12} /> Rua: Teste de endereço - N 99 - SÃO PAULO/SP</span>
                                    </div>

                                    <p className="bg-muted-foreground/30 px-2 rounded-md">ATIVO</p>
                                    <Button variant="ghost" size="icon" onClick={() => alert("Visualizar")}>
                                        <Eye className="w-4 h-4" />
                                    </Button>
                                </div>
                                <span>Aluguel: R$ 1000,00 </span>
                                <span>Encargos: R$ 1000,00 </span>
                            </div>

                            <div className="flex flex-col border p-2 rounded-md bg-muted/50">
                                <div className="flex items-center justify-between">
                                    <p className="font-medium">Descricao do Contrato</p>
                                    <p className="bg-muted-foreground/30 px-2 rounded-md">INATIVO</p>
                                    <Button variant="ghost" size="icon" onClick={() => alert("Visualizar")}>
                                        <Eye className="w-4 h-4" />
                                    </Button>
                                </div>

                                <span className=" flex items-center gap-2"> <MapPin size={16} /> Rua: Teste de endereço - N 99 - SÃO PAULO/SP</span>
                                <span>Aluguel: R$ 1000,00 </span>
                                <span>Encargos: R$ 1000,00 </span>
                            </div>
                        </CardContent>
                    </Card>
                </TabsContent>
                <TabsContent value="financas">
                    <Card className="w-full">
                        <CardContent className="space-y-4">
                            <Alert className="bg-amber-100">
                                <BanknoteX />
                                <AlertTitle>Receita Pendente - R$ 100,00</AlertTitle>
                                <AlertDescription>
                                    Descrição: Nome da fatura - Vencimento: 10/10/2023
                                </AlertDescription>
                            </Alert>
                            <Alert className="bg-amber-100">
                                <BanknoteX />
                                <AlertTitle>Despesa Pendente - R$ 100,00</AlertTitle>
                                <AlertDescription>
                                    Descrição: Nome da fatura - Vencimento: 10/10/2023
                                </AlertDescription>
                            </Alert>
                            <Alert className="bg-red-100">
                                <BanknoteArrowDown />
                                <AlertTitle>Despesa Paga - R$ 100,00</AlertTitle>
                                <AlertDescription>
                                    Descrição: Nome da fatura - Vencimento: 10/10/2023
                                </AlertDescription>
                            </Alert>
                            <Alert className="bg-green-100">
                                <BanknoteArrowUp />
                                <AlertTitle>Receita Paga - R$ 100,00</AlertTitle>
                                <AlertDescription>
                                    Descrição: Nome da fatura - Vencimento: 10/10/2023
                                </AlertDescription>
                            </Alert>
                        </CardContent>
                    </Card>
                </TabsContent>
                <TabsContent value="arquivos">
                    <Card className="w-full">
                        <CardContent className="space-y-4">
                            <div className="flex justify-between items-center border p-2 rounded-md bg-muted/50">
                                <div className="flex items-center gap-4">
                                    <div className="text-muted-foreground">
                                        <FileText className="w-8 h-8" />
                                    </div>
                                    <div className="flex flex-col">
                                        <span className="font-medium">documento_aleatorio.pdf</span>
                                        <span>Descricao a respeito do arquivo</span>
                                        <span className="text-sm text-muted-foreground">1.2 MB</span>
                                    </div>
                                </div>
                                <div className="flex gap-2">
                                    <Button variant="ghost" size="icon" onClick={() => alert("Visualizar")}>
                                        <Eye className="w-4 h-4" />
                                    </Button>
                                    <Button variant="ghost" size="icon" onClick={() => alert("Baixar")}>
                                        <Download className="w-4 h-4" />
                                    </Button>
                                    <Button variant="ghost" size="icon" onClick={() => alert("Excluir")}>
                                        <Trash className="w-4 h-4" />
                                    </Button>
                                </div>
                            </div>
                            <div className="flex justify-between items-center border p-2 rounded-md bg-muted/50">
                                <div className="flex items-center gap-4">
                                    <div className="text-muted-foreground">
                                        <FileImage className="w-8 h-8" />
                                    </div>
                                    <div className="flex flex-col">
                                        <span className="font-medium">documento_aleatorio.pdf</span>
                                        <span>Descricao a respeito do arquivo</span>
                                        <span className="text-sm text-muted-foreground">1.2 MB</span>
                                    </div>
                                </div>
                                <div className="flex gap-2">
                                    <Button variant="ghost" size="icon" onClick={() => alert("Visualizar")}>
                                        <Eye className="w-4 h-4" />
                                    </Button>
                                    <Button variant="ghost" size="icon" onClick={() => alert("Baixar")}>
                                        <Download className="w-4 h-4" />
                                    </Button>
                                    <Button variant="ghost" size="icon" onClick={() => alert("Excluir")}>
                                        <Trash className="w-4 h-4" />
                                    </Button>
                                </div>
                            </div>
                            <div className="flex justify-between items-center border p-2 rounded-md bg-muted/50">
                                <div className="flex items-center gap-4">
                                    <div className="text-muted-foreground">
                                        <File className="w-8 h-8" />
                                    </div>
                                    <div className="flex flex-col">
                                        <span className="font-medium">documento_aleatorio.pdf</span>
                                        <span>Descricao a respeito do arquivo</span>
                                        <span className="text-sm text-muted-foreground">1.2 MB</span>
                                    </div>
                                </div>
                                <div className="flex gap-2">
                                    <Button variant="ghost" size="icon" onClick={() => alert("Visualizar")}>
                                        <Eye className="w-4 h-4" />
                                    </Button>
                                    <Button variant="ghost" size="icon" onClick={() => alert("Baixar")}>
                                        <Download className="w-4 h-4" />
                                    </Button>
                                    <Button variant="ghost" size="icon" onClick={() => alert("Excluir")}>
                                        <Trash className="w-4 h-4" />
                                    </Button>
                                </div>
                            </div>
                        </CardContent>
                    </Card>
                </TabsContent>
            </Tabs>
        </div>
    );
}