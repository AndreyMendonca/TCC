import { Avatar } from "@/components/ui/avatar"
import { Separator } from "@/components/ui/separator"
import { AvatarFallback, AvatarImage } from "@radix-ui/react-avatar"
import { AtSign, CalendarDays, IdCard, IdCardLanyard, MapPinHouse, Phone, Pin, ScanFace } from "lucide-react"

export const InformacaoPessoal = () => {
    return (
        <div className="border-2 rounded-md w-full">
            <div>
                <div className="bg-muted/50 p-2 font-semibold">
                    <p>Informações da Pessoa</p>
                </div>
                <div className="sm:flex">
                    <div>
                        <Avatar className="h-24 w-24 m-4 border">
                            <AvatarImage src="https://github.com/shadcn.png" />
                            <AvatarFallback>CN</AvatarFallback>
                        </Avatar>
                    </div>
                    <div className="px-6 py-2">
                        <p className="font-semibold">
                            Andrey Marques Mendonça
                        </p>
                        <p className="flex gap-2 items-center">
                            <CalendarDays size={16}/>
                            10/10/2000
                        </p>
                        <p className="flex gap-2 items-center">
                            <Phone size={16} />
                            18 996698229
                        </p>
                        <p className="flex gap-2 items-center">
                            <AtSign size={16} />
                            <span className="truncate">andrey.mmendonca@gmail.com</span>
                        </p>
                    </div>
                </div>
            </div>
            <Separator />
            <div>
                <div className="bg-muted/50 p-2 font-semibold">
                    <p>Dados</p>
                </div>
                <div className="px-6 py-2">
                    <p className="flex gap-2 items-center">
                        <IdCard size={16} />
                        123.456.789-10
                    </p>
                    <p className="flex gap-2 items-center">
                        <IdCardLanyard size={16} />
                        Engenheiro
                    </p>
                    <p className="flex gap-2 items-center">
                        <ScanFace size={16} />
                        Inquilino
                    </p>
                    <p className="flex gap-2 items-center">
                        <Pin size={16} />
                        Ativo
                    </p>
                </div>
            </div>
            <Separator />
            <div>
                <div className="bg-muted/50 p-2 font-semibold">
                    <p>Endereço</p>
                </div>
                <div className="px-6 py-2">
                    <p className="flex gap-2 items-center">
                        <MapPinHouse size={16} />
                        Rua Exemplo, 123, Bairro Exemplo, Cidade Exemplo - SP
                    </p>
                </div>
            </div>


        </div>
    )
}