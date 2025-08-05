import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { InformacaoPessoas } from "./informacao-pessoas";

export const CartaoPessoa = () => {
    return (
        <Card>
            <CardHeader>
                <CardTitle className="text-xl">Informações da pessoa</CardTitle>
            </CardHeader> 
            <CardContent className="flex justify-between">
                <InformacaoPessoas/>
                <InformacaoPessoas/>
            </CardContent>
        </Card>
        
    );
}
